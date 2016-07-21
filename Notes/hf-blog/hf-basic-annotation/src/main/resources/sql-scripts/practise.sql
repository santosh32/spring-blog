DELETE FROM address;
DELETE FROM employee;
commit;

select * from employee e, address a where e.emp_id = A.employee_emp_id;