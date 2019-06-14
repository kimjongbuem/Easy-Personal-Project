select department.dept_name,SUM(salary) as sum_salary
 from department left outer join instructor on department.dept_name = instructor.dept_name
 group by department.dept_name,instructor.dept_name
 
select department.dept_name,(case when SUM(salary) is null then 0.00 else SUM(salary) end)as sum_salary
 from department left outer join instructor on department.dept_name = instructor.dept_name
 group by department.dept_name,instructor.dept_name
 