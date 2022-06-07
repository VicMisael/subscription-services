create schema subscription

    create table if not exists subscription.users
    (
        user_id    SERIAl primary key,
        full_name  varchar(255) not null,
        dt_created date         not null
    )

    create table if not exists subscription.subscriptions
    (
        subscription_id     SERIAL primary key,
        user_id             SERIAL not null unique,
        subscription_status varchar(100),
        created_at          date   not null,
        updated_at          date   not null,
        constraint fk_user_id FOREIGN KEY (user_id)
            references subscription.users (user_id)
    )
