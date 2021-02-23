use picture;

create table `border` (
    `border_id`       tinyint     not null    auto_increment,
    `border`          varchar(6)  not null,

    primary key `pk_border_border_id` (`border_id`)
) engine = InnoDB;

alter table `border`
    add constraint `uk_border_border` unique (`border`);

insert into `border`
    (`border_id`, `border`) values
    (1, 'SOLID'),
    (2, 'DOTTED'),
    (3, 'DASHED');

create table `orientation` (
    `orientation_id`  tinyint     not null    auto_increment,
    `orientation`     varchar(3)  not null,

    primary key `pk_orientation_orientation_id` (`orientation_id`)
) engine = InnoDB;

alter table `orientation`
    add constraint `uk_orientation_orientation` unique (`orientation`);

insert into `orientation`
    (`orientation_id`, `orientation`) values
    (1, 'ROW'),
    (2, 'COL');
