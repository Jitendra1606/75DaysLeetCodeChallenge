# Write your MySQL query statement below
SELECT p.project_id,
ROUND(COALESCE(SUM(e.experience_years) / COUNT(p.employee_id), 0), 2)
AS average_years
FROM Project AS p
LEFT JOIN Employee AS e
ON e.employee_id = p.employee_id
GROUP BY project_id;