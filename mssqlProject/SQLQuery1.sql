select course.title, prereq.prereq_id
from course CROSS JOIN prereq
where course.title = 'Geology'