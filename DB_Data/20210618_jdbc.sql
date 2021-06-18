-- 20210618

-- JDBC

select * from dept01;

-- dept01 deptno 에 입력할 일련 번호 -> sequence

create sequence dept01_deptno_seq
start with 10
increment by 10
;

insert into dept01 values (DEPT01_DEPTNO_SEQ.nextval, 'dev', 'SEdfOUL');

commit;
