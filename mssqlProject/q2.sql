select* from course as c where c.course_id not in (select p.course_id from prereq as p where p.course_id = c.course_id);

create view No_prerequisite_Course as 
select* from course as c where c.course_id not in (select p.course_id from prereq as p where p.course_id = c.course_id);

select*
from No_prerequisite_Course