/*==============================================================*/
/* Table: tab_user                                              */
/*==============================================================*/
create table tab_user
(
    uid                  int not null auto_increment,
    username             varchar(100) not null,
    password             varchar(32) not null,
    name                 varchar(100),
    birthday             date,
    sex                  char(1),
    telephone            varchar(11),
    email                varchar(100),
    status               char(1) ,
    code					varchar(50),

    primary key (uid),
    unique key AK_nq_username (username),
    unique key AK_nq_code (code)
);