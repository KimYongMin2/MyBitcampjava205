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