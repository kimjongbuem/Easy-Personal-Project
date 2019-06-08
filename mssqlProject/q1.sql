select dept_name, (case
	when dept_name is null then 0.00
	else
	SUM(salary)
	end
	) as sum_salary
 from instructor  group by dept_name

