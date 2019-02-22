select class 
from 
(
    select count(distinct(student)) as c,class from courses group by class
) as a
where c>=5;
