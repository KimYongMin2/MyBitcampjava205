
-- phoneInfo_basic
-- select
select * from phoneinfo_basic;

desc phoneinfo_basic;

-- insert 
insert into phoneinfo_basic (idx , fr_name , fr_phonenumber, fr_email, fr_address , fr_regdate)
values (1 , '홍길동' , '0101' , 'naver' , '서울' , sysdate);

insert into phoneinfo_basic (idx , fr_name , fr_phonenumber)
values (2 , '홍길순' , '0102');

insert into phoneinfo_basic (idx , fr_name , fr_phonenumber)
values (3 , '업데이트용' , '0103');

insert into phoneinfo_basic (idx , fr_name , fr_phonenumber)
values (4 , '딜리트용' , '0104');

insert into phoneinfo_basic (idx , fr_name , fr_phonenumber, fr_email, fr_address , fr_regdate)
values (5 , '홍길동' , '0101' , 'naver' , '서울' , sysdate);

insert into phoneinfo_basic (idx , fr_name , fr_phonenumber)
values (6 , '홍길순' , '0102');

insert into phoneinfo_basic (idx , fr_name , fr_phonenumber)
values (7 , '업데이트용' , '0103');

insert into phoneinfo_basic (idx , fr_name , fr_phonenumber)
values (8 , '딜리트용' , '0104');

insert into phoneinfo_basic (idx , fr_name , fr_phonenumber, fr_email, fr_address , fr_regdate)
values (9 , '홍길동' , '0101' , 'naver' , '서울' , sysdate);

insert into phoneinfo_basic (idx , fr_name , fr_phonenumber)
values (10 , '홍길순' , '0102');

insert into phoneinfo_basic (idx , fr_name , fr_phonenumber)
values (11 , '업데이트용' , '0103');

insert into phoneinfo_basic (idx , fr_name , fr_phonenumber)
values (12 , '딜리트용' , '0104');

-- update
update phoneinfo_basic
set fr_regdate = sysdate+1;

update phoneinfo_basic
set fr_regdate = sysdate+1
where idx = 3;

-- delete
delete from phoneinfo_basic
where idx = 4;

-------------------------------------------------------------------------------
-- phoneinfo_univ
-- select
select * from phoneinfo_univ;

desc phoneinfo_univ;

-- insert 
-- 값 : IDX => PK, FR_U_MAJOR의 기본값 N , FR_U_YEAR => 1~4 사이 , FR_REF => 외래키 => phoneinfo_basic 의 inx 값
insert into phoneinfo_univ (IDX , FR_U_MAJOR , FR_U_YEAR, FR_REF)
values (1 , '국어' , '1' , '5');

insert into phoneinfo_univ (IDX , FR_U_MAJOR , FR_U_YEAR, FR_REF)
values (2 , '업데이트' , '1' , '7');

insert into phoneinfo_univ (IDX , FR_U_MAJOR , FR_U_YEAR, FR_REF)
values (3 , '삭제' , '1' , '8');

-- update
update phoneinfo_univ
set FR_U_YEAR = FR_U_YEAR+1;

update phoneinfo_univ
set FR_U_YEAR = FR_U_YEAR+1
where idx = 2;


-- delete
delete from phoneinfo_univ
where idx = 3;




-------------------------------------------------------------------------------
-- phoneinfo_univ
-- select
select * from phoneinfo_com;
desc phoneinfo_com;

-- insert 
-- 값 : IDX => PK, fr_c_company 기본값 N , FR_REF => 외래키 => phoneinfo_basic 의 inx 값
insert into phoneinfo_com (idx, fr_c_company, fr_ref)
values (1 , '학원' , '9');

insert into phoneinfo_com (idx, fr_c_company, fr_ref)
values (2 , '업데이트'  , '11');

insert into phoneinfo_com (idx, fr_c_company, fr_ref)
values (3 , '삭제' , '12');

-- update
update phoneinfo_com
set fr_c_company = '업데이트용';

update phoneinfo_com
set fr_c_company = '업데이트'
where idx = 2;

-- delete
delete from phoneinfo_com
where idx = 3;

