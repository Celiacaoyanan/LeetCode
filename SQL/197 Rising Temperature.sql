select w1.Id
from Weather as w1, Weather as w2
where TO_DAYS(w1.RecordDate)-TO_DAYS(w2.RecordDate)=1 and w1.Temperature>w2.Temperature;
