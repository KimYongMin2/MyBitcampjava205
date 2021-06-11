-- 2021.06.09
select * from tab;
DESC tab;
DESC dept;

select * from emp;

select empno, ename
from emp;

select sal, comm, sal*comm, sal*12, sal/10, sal-100, sal+100
from emp;

select ename, job, sal, comm, sal*12 as ysall, sal*12+comm as ysa12
from emp;

select ename, job, sal, nvl(comm,0), sal*12 as ysall, sal*12+nvl(comm,0) as ysa12
from emp;


-- 2021.06.10

-- 특정 데이터 검색 : 행 검색 ->컬럼 선택

-- 10번 부서의 사원 리스트를 출력
-- 10번 부서 -> where dept = 10
select *
from emp
where deptno = 10
;

-- 이름이 'SCOTT'인 사원을 출력
-- 대소문자 구분
SELECT *
FROM EMP
WHERE ENAME = 'SCOTT'
;
SELECT *
FROM EMP
WHERE ENAME = 'scott'
;

-- 날짜타입의 데이터 비교시에도 작은 따옴표를 이용해야한다.
select *
from emp
where hiredate = '96/11/17'
;

-- 논리연산자 : and, or, not
-- 10번 부서의 관리자(manager)를 찾아 출력
select *
from emp
where deptno = 10 and job = 'MANAGER'
;

--10번 부서의 직원들과 관리자들의 리스트를 출력
select empno, ename, job
from emp
where deptno = 10 or job = 'MANAGER'
;

-- 10번 부서의 직원을 제외한 나머지 직원들을 출력
-- 20번 30번 40번
select *
from emp
--where deptno = 20 or deptno = 30 or deptno = 40
where not deptno = 10
;

-- 범위 연산을 할 때 -> 논리연산자 이용, between a and b
-- between a and b : a 이상 ~ b 이하


-- 급여를 2000 이상 3000 이하의 급여를 받는 직원의 리스트 
select ename,job, sal, sal*1.2 as upsal
from emp
--where sal >= 2000 and sal <=3000
where sal between 2000 and 3000
;

select *
from emp
where hiredate >= '87/01/01' and hiredate <= '87/12/31'
order by hiredate
;

--패턴검색 : 키워드검색 
-- 컬럼 like '%'
-- ename like 'F%' -> F로 시작하는 문자열
-- ename like '%F' -> F로 끝나는 문자열
-- ename like '%F%' -> F를 포함하는 문자열

select *
from emp
where ename like '%L%K%';


-- 급여가 큰 사원부터 출력하고 같으면 이름 오름차순으로
select ename, sal from emp
order by sal desc , ename asc;

-- 2021. 06. 10
-- function :단일행 함수, 집합(다중행)함수
-- 단일행 함수 : 하나의 행이 포함하는 특정 컬럼의 값 하나를 처리하고 반환
-- 다중행(집합) 함수 : 여러행의 특정 컬럼값들을 대상으로 연산하고 반환

-- 숫자 함수
select abs(10), abs(-10)
from dual
;

select FLOOR(15.7)
from dual
;
--2 , -1 반올림자리수
select ROUND(15.198,2), ROUND(15.193,-1)
from dual
;
--숫자삭제
select TRUNC(15.79,1), trunc(15.79)
from dual
;
--나머지
select MOD(11,5)
from dual
;

--사원 들의 급여
select sal, mod(sal,2)
from emp
where mod(sal,2) = 1
;

-- 문자 함수
-- concat(문자,문자) -> '' || ''
select concat('abc', 'efg'), 'abc' || 'efg'
from dual
;

-- substr : 문자열 추출
-- substr(문자열, 시작 위치, 길이)
select substr('apple', 1, 3)
from dual
;

select substr('apple', -3)
from dual
;

-- replace : 특정 문자열(패턴) 다른 문자열(패턴)으로 변경
select REPLACE('JACK and JUE','J','BL')
from dual;

------------------------------------------------------------
-- 2021.06.11
------------------------------------------------------------

-- 형변환 함수
-- 날짜 
-- 2021.06.11
-- 형변환 함수
-- 날짜-문자, 숫자->문자
-- to_char(날자 데이터, '패턴'), to_char(숫자,'패턴')
select sysdate, to_char(sysdate, 'YYYY.MM.DD. HH24:MI:SS')
fROM dual
;
-- 문자->숫자, 문자-날짜
select ename, hiredate, to_char(hiredate, 'YYYY.MM.DD.')
fROM emp
;

select * from orders;
select orderid, orderdate, to_char(orderdate, 'YYYY.MM.DD')
from orders
;

-- 숫자 -> 문자
select to_char(123456, '0,000,000,000'), to_char(123456, 'L9,999,999,999')
from dual
;

select ename, sal, to_char(sal*1100, 'L9,999,999,999')
from emp
;

-- '1,000,000' + 100000

-- 문자 ->숫자,
-- to_number(문자열,패턴)
select TO_NUMBER('1,000,000', '9,999,999'),
       TO_NUMBER('1,000,000', '9,999,999') +1000000
from dual
;

-- 문자 -날짜
-- to_date(문자열, 패턴)  만 나이 구하기 , trunc 소수점 자르기 sysdate-to_date 지금날짜와 적힌날짜 계산
select to_date('2012-05-17', 'YYYY.MM.DD'), trunc((sysdate-to_date('2012-05-17', 'YYYY.MM.DD'))/365)
from dual
;

-- decode 함수 : 분기를 위해 사용 switch-case 유사
-- decode(컬럼, = 조건1 값, 조건1의 참일때 사용할 값
--            , 조건2 값, 조건2의 참일때 사용할 값
--            , ....
--)

-- emp 테이블에서 부서번호에 맞는 부서이름 출력
select*
from dept
;

-- 10 ACCOUNTING
-- 20 RESEARCH
-- 30 SALES
-- 40 OPERATIONS

select ename, deptno,
        decode(deptno, 10, 'ACCOUNTING',
                       20, 'RESEARCH',
                       30, 'SALES',
                       40, 'OPERATIONS'
        )
from emp
;