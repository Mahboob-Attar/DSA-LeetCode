# Write your MySQL query statement below
select id,movie,description,rating
from Cinema
where id%2=1 And description not in('boring')
ORDER BY rating DESC;