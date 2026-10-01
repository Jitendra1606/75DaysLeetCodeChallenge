# Write your MySQL query statement below
-- 1. using order by and limit

SELECT(
    SELECT DISTINCT salary 
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;

-- Now even if the inner query returns no row, the outer SELECT still returns one row, with NULL.

-- 2. using max function

-- SELECT MAX(salary) AS SecondHighestSalary
-- FROM Employee
-- WHERE salary < (SELECT MAX(salary) FROM Employee);



-- 3. using if condition

-- SELECT IF(
--     COUNT(DISTINCT salary) >= 2,
--     (
--         SELECT DISTINCT salary
--         FROM Employee
--         ORDER BY salary DESC
--         LIMIT 1 OFFSET 1
--     ),
--     NULL
--     )  AS SecondHighestSalary
-- FROM Employee;