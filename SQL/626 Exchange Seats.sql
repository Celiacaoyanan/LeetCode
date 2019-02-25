select 
( case when mod(id,2)=0 then id-1 # even id 
       when mod(id,2)=1 and id!=c then id+1 #odd id and not the last ont
       else id # odd id and last one
  end
     
) as id, student
from seat, (select count(*) as c from seat) as c1
order by id asc;
