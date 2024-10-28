package com.example.internalbookingmanagement.security;


import com.example.internalbookingmanagement.dto.ApiResponse;
import com.example.internalbookingmanagement.dto.JwtAuthResponse;
import com.example.internalbookingmanagement.dto.ReqLogin;
import com.example.internalbookingmanagement.dto.ReqUser;
import com.example.internalbookingmanagement.entity.BaseUser;
import com.example.internalbookingmanagement.repo.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public ApiResponse register(ReqUser reqUser) {
        BaseUser user = userRepo.save(
                BaseUser.builder()
                        .password(passwordEncoder.encode(reqUser.password()))
                        .userName(reqUser.username())
                        .build()
        );
        return new ApiResponse(true, user);
    }

    public ApiResponse login(ReqLogin reqLogin) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        reqLogin.username(),
                        reqLogin.password()
                )
        );
        BaseUser user = userRepo.findByUserName(reqLogin.username()).orElseThrow(() -> new UsernameNotFoundException("user not found!"));
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user.getUsername());
        return new ApiResponse(true, new JwtAuthResponse(accessToken, refreshToken));
    }

    public ApiResponse refreshToken(HttpServletRequest request, HttpServletResponse response) {
        try {
            String authorizationHeader = request.getHeader("REFRESH_TOKEN");
            String bearer = "Bearer ";
            if (authorizationHeader != null && authorizationHeader.startsWith(bearer)) {
                String token = authorizationHeader.substring(bearer.length());
                String phone = jwtService.extractUsernameFromJWT(token);
                BaseUser user = userRepo.findByUserName(phone).orElseThrow(() -> new ServiceException("user not found"));
                String accessToken = jwtService.generateAccessToken(user);
                String refreshToken = jwtService.generateRefreshToken(user.getUsername());
                return new ApiResponse(true, new JwtAuthResponse(accessToken, refreshToken), null);
            } else {
                throw new ServiceException("Header not found");
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
