# Write your MySQL query statement below
SELECT e1.employee_id,
e1.name,
COUNT(e2.reports_to) AS reports_count,
ROUND(AVG(e2.age), 0) AS average_age
FROM Employees AS e1
LEFT JOIN Employees AS e2
ON e1.employee_id = e2.reports_to
WHERE e2.employee_id IS NOT NULL
GROUP BY employee_id
ORDER BY employee_id;


-- SELECT e1.employee_id, 
-- e1.name, 
-- COUNT(e2.employee_id)AS reports_count,
-- ROUND(AVG(e2.age), 0) AS average_age
-- FROM Employees AS e1
-- JOIN Employees AS e2
-- ON e1.employee_id = e2.reports_to
-- GROUP BY employee_id
-- ORDER BY employee_id;