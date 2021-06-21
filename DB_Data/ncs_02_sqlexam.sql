create table Contact (
-- 기본정보
pIdx number(4) constraint Contact_pIdx_PK primary key,
cname varchar(20) constraint Contact_cname_NN not null,
phonenum varchar(20) constraint Contact_phonenum_NN not null,
address varchar(20) constraint Contact_address_NN not null,
email varchar(20) constraint Contact_email_NN not null,
ctype varchar(20) constraint Contact_ctype_CK check(ctype in('univ','com','cafe'))not null,
-- 선택정보
major varchar(20),
grade number(4),
comname varchar(20),
dname varchar(20),
drank varchar(20),
groupname varchar(20),
nickname varchar(20)
);