create table digital_tv_contracts(
    id int not null,
    start_date date not null,
    end_date date not null,
    contract_number int not null,
    owner_id int not null,
    channel_packages varchar(255) not null
);

create table mobile_phone_contracts(
    id int not null,
    start_date date not null,
    end_date date not null,
    contract_number int not null,
    owner_id int not null,
    number_of_minutes int not null,
    number_of_sms int not null,
    amount_of_traffic int not null
);

create table wired_internet_contracts(
    id int not null,
    start_date date not null,
    end_date date not null,
    contract_number int not null,
    owner_id int not null,
    connection_speed int not null
);

create table persons(
    id int not null,
    fio varchar(255) not null,
    birth_date date not null,
    gender varchar(255) not null,
    passport_series_and_number int not null
);