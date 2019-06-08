with teachesCourseIDAndYear(course_id, year) as
(select teaches.course_id, teaches.year
from teaches
where teaches.ID in (
select instructor.ID from instructor where instructor.name = 'Dale')),

getTakeEqualID(ID)as
(select takes.ID  from takes, teachesCourseIDAndYear 
where (takes.course_id = teachesCourseIDAndYear.course_id) and (takes.year = teachesCourseIDAndYear.year)
)
select distinct student.ID , name, dept_name, tot_cred
from student join getTakeEqualID on(student.ID = getTakeEqualID.ID)

select * from student where tot_cred = 130


create function
checkNameTable(@totcred int)
returns table
as

	return (select student.name  from student where @totcred = student.tot_cred)

sp_dbcmptlevel 'LargeDB', 90
select dbo.checkName(130)

create function [dbo].[inst_advise_takes_year]
(@inst_name varchar(20), @takes_year int)
returns TABLE
AS

RETURN(
	with teachesCourseIDAndYear(course_id, year) as
(select teaches.course_id, teaches.year
from teaches
where teaches.ID in (
select instructor.ID from instructor where instructor.name = @inst_name)),

getTakeEqualID(ID)as
(select takes.ID  from takes, teachesCourseIDAndYear 
where (takes.course_id = teachesCourseIDAndYear.course_id) and (@takes_year = teachesCourseIDAndYear.year)
)
	select tot_cred
	from student join getTakeEqualID on(student.ID = getTakeEqualID.ID)
)


select dbo.inst_advise_takes_year('Dale',2008);
