create table users_tb(
	id bigint not null primary key auto_increment,
    username varchar(255) not null unique,
    user_password varchar(255) not null,
    email varchar(255) not null unique,
    phone varchar(20) not null unique,
    user_type varchar(15) not null
);

create table events_tb(
	id bigint not null primary key auto_increment,
    title varchar(255) not null,
	event_description text,
    start_date_time datetime not null,
    end_date_time datetime not null,
    location varchar(255) not null,
    capacity integer not null,
    user_id bigint not null,
    foreign key (user_id) references users_tb(id)
);

create table participants_tb (
	id bigint not null primary key auto_increment,
	participant_name varchar(255) not null,
    email varchar(255) not null,
    phone varchar(20) not null,
    user_id bigint not null,
    foreign key (user_id) references users_tb(id)
);

create table participants_events_tb (
	id bigint not null primary key auto_increment,
    registration_date_time datetime not null,
    participant_status varchar(30) not null,
    participant_id bigint not null,
    event_id bigint not null,
    foreign key (participant_id) references participants_tb(id),
    foreign key (event_id) references events_tb(id)
);

create table invitations_tb(
	id bigint not null primary key auto_increment,
    email varchar(255) not null,
    invite_date_time datetime not null,
    event_id bigint not null,
    foreign key (event_id) references events_tb(id)
);
