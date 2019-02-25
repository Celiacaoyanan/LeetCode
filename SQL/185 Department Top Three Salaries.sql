select d.Name as Department, e1.Name as Employee, e1.Salary as Salary
from Employee as e1 inner join Department as d
on d.Id=e1.DepartmentId
where
(
    (select count(distinct Salary) from Employee where Salary>e1.Salary and DepartmentId=e1.DepartmentId)<3
);
