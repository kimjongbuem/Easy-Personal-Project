select distinct student.dept_name, student.name, student.tot_cred
from  student
where student.dept_name = 'Physics'



select distinct teaches.course_id, teaches.semester
from instructor CROSS JOIN teaches
where instructor.dept_name = 'Physics' and teaches.year = 2018
