create table bank_details (
    id UUID primary key not null,
    bank_name varchar(255) not null,
    iban varchar(255),
    swift varchar(255),
    recipient_name varchar(255) not null,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now()
);

CREATE TABLE base_user (
    id UUID PRIMARY KEY NOT NULL,
    status VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    role VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now()
);

create table hotel(
                      id UUID primary key not null,
                      order_number varchar(255) not null,
                      external_id UUID not null,
                      country varchar(255) not null,
                      city varchar(255) not null,
                      created_at TIMESTAMP NOT NULL DEFAULT now(),
                      updated_at TIMESTAMP NOT NULL DEFAULT now()
);

create table profile (
                         id UUID primary key not null,
                         status varchar(255) not null,
                         name varchar(255) not null,
                         surname varchar(255) not null,
                         nationality varchar(255),
                         date_of_birth timestamp not null,
                         created_at TIMESTAMP NOT NULL DEFAULT now(),
                         updated_at TIMESTAMP NOT NULL DEFAULT now()
);

create table employee (
                          id UUID primary key not null references base_user (id),
                          phone varchar(255) not null,
                          photo varchar(255),
                          created_at TIMESTAMP NOT NULL DEFAULT now(),
                          updated_at TIMESTAMP NOT NULL DEFAULT now(),
                          profile_id UUID not null references profile (id)
);

create table orders(
                      id UUID primary key not null,
                      status varchar(255) not null,
                      order_number varchar(255) not null,
                      hotel_id UUID not null references hotel (id),
                      employee_admin UUID not null references employee (id),
                      check_in timestamp not null default now(),
                      check_out timestamp not null default now(),
                      created_at TIMESTAMP NOT NULL DEFAULT now(),
                      updated_at TIMESTAMP NOT NULL DEFAULT now(),
                      total_price double precision not null,
                      payment_id UUID not null
);

create table company (
    id UUID primary key not null,
    status varchar(255) not null,
    name varchar(255) not null,
    industry varchar(255),
    company_size integer,
    registration_code varchar(255),
    vat_code varchar(255),
    registration_address varchar(255),
    country varchar(255),
    logo varchar(255),
    created_at timestamp not null default now(),
    updated_at timestamp not null default now(),
    bank_details_id UUID not null references bank_details (id)

);

create table request(
                        id UUID primary key not null,
                        status varchar(255) not null,
                        created_at TIMESTAMP NOT NULL DEFAULT now(),
                        updated_at TIMESTAMP NOT NULL DEFAULT now(),
                        order_id UUID not null references orders (id)
);

create table room (
                      id UUID primary key not null,
                      room_name varchar(255) not null,
                      amenities varchar(255),
                      board varchar(255),
                      free_cancellation_until timestamp default now(),
                      price double precision,
                      number integer,
                      created_at TIMESTAMP NOT NULL DEFAULT now(),
                      updated_at TIMESTAMP NOT NULL DEFAULT now(),
                      hotel_id UUID not null references hotel(id)
);

create table super_admin(
    id UUID primary key not null references base_user (id),
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now()
);

create table company_admin (
    id UUID primary key not null references base_user (id),
    phone varchar(255) not null,
    photo varchar(255),
    profile_id UUID not null references profile (id),
    company_id UUID not null references company(id)
);

create table message (
    id UUID primary key not null,
    owner UUID not null references base_user (id),
    text varchar(255) not null,
    request_id UUID not null references request (id),
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now()
);


