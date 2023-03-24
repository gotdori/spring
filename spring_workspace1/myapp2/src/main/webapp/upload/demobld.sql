--
-- Copyright (c) Oracle Corporation 1988, 1999.  All Rights Reserved.
--
--  NAME
--    demobld.sql
--
-- DESCRIPTION
--   This script creates the SQL*Plus demonstration tables in the
--   current schema.  It should be STARTed by each user wishing to
--   access the tables.  To remove the tables use the demodrop.sql
--   script.
--
--  USAGE
--       SQL> START demobld.sql
--
--

SET TERMOUT ON
PROMPT Building demonstration tables.  Please wait.
SET TERMOUT OFF
drop table bonus;
drop table emp;
drop table salgrade;
drop table dept;
drop table locations;

CREATE TABLE BONUS
        (ENAME VARCHAR2(10),
         JOB   VARCHAR2(9),
         SAL   NUMBER,
         COMM  NUMBER);

CREATE TABLE EMP
       (EMPNO NUMBER(4) NOT NULL,
        ENAME VARCHAR2(10),
        JOB VARCHAR2(9),
        MGR NUMBER(4),
        HIREDATE DATE,
        SAL NUMBER(7, 2),
        COMM NUMBER(7, 2),
        DEPTNO NUMBER(2),
				gender char(1));

INSERT INTO EMP VALUES
        (7369, 'SMITH',  'CLERK',     7902,
        '1980-12-17',  800, NULL, 20, 'M');
INSERT INTO EMP VALUES
        (7499, 'ALLEN',  'SALESMAN',  7698,
        '1981-02-20', 1600,  300, 30, 'M');
INSERT INTO EMP VALUES
        (7521, 'WARD',   'SALESMAN',  7698,
        '1981-02-22', 1250,  500, 30, 'M');
INSERT INTO EMP VALUES
        (7566, 'JONES',  'MANAGER',   7839,
        '1981-04-02',  2975, NULL, 20, 'M');
INSERT INTO EMP VALUES
        (7654, 'MARTIN', 'SALESMAN',  7698,
        '1981-08-28', 1250, 1400, 30, 'M');
INSERT INTO EMP VALUES
        (7698, 'BLAKE',  'MANAGER',   7839,
        '1981-05-01',  2850, NULL, 30, 'M');
INSERT INTO EMP VALUES
        (7782, 'CLARK',  'MANAGER',   7839,
        '1981-06-09',  2450, NULL, 10, 'M');
INSERT INTO EMP VALUES
        (7788, 'SCOTT',  'ANALYST',   7566,
        '1982-10-09', 3000, NULL, 20, 'M');
INSERT INTO EMP VALUES
        (7839, 'KING',   'PRESIDENT', NULL,
        '1981-11-17', 5000, NULL, 10, 'M');
INSERT INTO EMP VALUES
        (7844, 'TURNER', 'SALESMAN',  7698,
        '1981-8-8',  1500, NULL, 30, 'M');
INSERT INTO EMP VALUES
        (7876, 'ADAMS',  'CLERK',     7788,
        '1983-1-12', 1100, NULL, 20, 'M');
INSERT INTO EMP VALUES
        (7900, 'JAMES',  'CLERK',     7698,
        '1981-10-3',   950, NULL, 30, 'M');
INSERT INTO EMP VALUES
        (7902, 'FORD',   'ANALYST',   7566,
        '1981-10-3',  3000, NULL, 20, 'M');
INSERT INTO EMP VALUES
        (7934, 'MILLER', 'CLERK',     7782,
        '1982-1-23', 1300, NULL, 10, 'M');

CREATE TABLE DEPT
       (DEPTNO NUMBER(2),
        DNAME VARCHAR2(14),
        loc_code char(2) );

INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'A1');
INSERT INTO DEPT VALUES (20, 'RESEARCH',   'B1');
INSERT INTO DEPT VALUES (30, 'SALES',      'C1');
INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'D1');
INSERT INTO DEPT VALUES (50, 'INSA', 'E1');


CREATE TABLE LOCATIONS
       ( loc_code char(2) ,
        city VARCHAR2(14) );

INSERT INTO LOCATIONS VALUES ('A1', 'NEW YORK');
INSERT INTO LOCATIONS VALUES ('B1', 'DALLAS');
INSERT INTO LOCATIONS VALUES ('C1', 'CHICAGO');
INSERT INTO LOCATIONS VALUES ('D1', 'BOSTON');
INSERT INTO LOCATIONS VALUES ('E1', 'SEOUL');


CREATE TABLE SALGRADE
        (GRADE NUMBER,
         LOSAL NUMBER,
         HISAL NUMBER);

INSERT INTO SALGRADE VALUES (1,  700, 1200);
INSERT INTO SALGRADE VALUES (2, 1201, 1400);
INSERT INTO SALGRADE VALUES (3, 1401, 2000);
INSERT INTO SALGRADE VALUES (4, 2001, 3000);
INSERT INTO SALGRADE VALUES (5, 3001, 9999);

COMMIT;

SET TERMOUT ON
PROMPT Demonstration table build is complete.
