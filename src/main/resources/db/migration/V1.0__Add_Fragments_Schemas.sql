use picture;

create table `fragment` (
    `fragment_id`             bigint      not null    auto_increment,
    `parent_figure_group_id`  bigint,
    `queue_order`                   int,

    primary key `pk_fragment_fragment_id` (`fragment_id`)
) engine = InnoDB;

create table `figure_group` (
    `fragment_id`             bigint      not null    auto_increment,
    `orientation`             char(3)     not null,

    primary key `pk_figure_group_fragment_id` (`fragment_id`)
) engine = InnoDB;

alter table `figure_group`
    add constraint `fk_figure_group_fragment_id`
        foreign key (`fragment_id`)
            references `fragment` (`fragment_id`);

create table `circle` (
    `fragment_id`             bigint      not null    auto_increment,
    `border`                  varchar(6)  not null    default 1,

    primary key `pk_circle_fragment_id` (`fragment_id`)
) engine = InnoDB;

alter table `circle`
    add constraint `fk_circle_fragment_id`
        foreign key (`fragment_id`)
            references `fragment` (`fragment_id`);

create table `square` (
    `fragment_id`             bigint      not null    auto_increment,
    `inner_char`              char(1),

    primary key `pk_square_fragment_id` (`fragment_id`)
) engine = InnoDB;

alter table `square`
    add constraint `fk_square_fragment_id` foreign key (`fragment_id`) references `fragment` (`fragment_id`);

create table `triangle` (
    `fragment_id`             bigint      not null    auto_increment,
    `color`                   char(7)     not null    default '#000000',

    primary key `pk_triangle_fragment_id` (`fragment_id`)
) engine = InnoDB;

alter table `triangle`
    add constraint `fk_triangle_fragment_id` foreign key (`fragment_id`) references `fragment` (`fragment_id`);

alter table `fragment`
    add constraint `fk_fragment_parent_figure_group_id`
        foreign key (`parent_figure_group_id`)
            references `figure_group` (`fragment_id`);
