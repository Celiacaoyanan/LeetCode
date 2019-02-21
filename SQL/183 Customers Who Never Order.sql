select a.Name as Customers
from
(
select Customers.Id, Customers.Name, Orders.CustomerId  
from Customers left join Orders
on Customers.Id=Orders.CustomerId
) as a
where a.CustomerId is null; // don’t use =null


select Customers.Name as Customers 
from Customers
where Customers.Id not in (select Orders.CustomerId from Orders)
