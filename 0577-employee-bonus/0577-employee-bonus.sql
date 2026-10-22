# Write your MySQL query statement below
SELECT e.name AS name, b.bonus AS bonus
FROM Employee AS e
LEFT JOIN Bonus AS b
ON e.empId = b.empId
WHERE b.bonus < 1000 OR b.bonus IS NULL;


-- SELECT e.name AS name, b.bonus AS bonus
--        FROM Employee AS e
-- LEFT JOIN Bonus AS b
--        ON e.empId = b.empId
-- WHERE b.bonus < 1000 OR b.bonus IS NULL; 


-- SELECT e.name, b.bonus
-- FROM employee AS e
-- LEFT JOIN Bonus AS b
-- ON e.empId = b.empId
-- WHERE b.bonus < 1000 OR b.bonus IS NULL;
