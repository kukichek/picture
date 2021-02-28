create table `picture` (
    `picture_id`            int         not null    auto_increment,
    `title`                 varchar(80) not null,
    `root_figure_group_id`  bigint      not null,
    `created_at`            timestamp   not null    default current_timestamp,
    `modified_at`           timestamp   not null    default current_timestamp on update current_timestamp,

    primary key `pk_picture_picture_id` (`picture_id`)
) engine = InnoDB;

alter table `picture`
    add constraint `fk_picture_root_figure_group_id`
        foreign key (`root_figure_group_id`)
            references `figure_group` (`fragment_id`);

alter table `picture`
    add constraint `uk_picture_root_figure_group_id` unique (`root_figure_group_id`);

alter table `picture`
    add constraint `uk_picture_title` unique (`title`);

