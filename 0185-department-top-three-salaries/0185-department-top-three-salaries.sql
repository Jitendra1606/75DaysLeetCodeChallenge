# Write your MySQL query statement below
SELECT
       d.name AS Department,
       e.name AS Employee,
       e.salary AS Salary 

FROM Employee AS e
JOIN Department As d
    ON e.departmentId = d.id

WHERE 3 > (
    SELECT COUNT(DISTINCT e2.salary)
    FROM Employee AS e2
    WHERE e2.departmentId = e.departmentId
    AND e2.salary > e.salary
);



-- Let's understand the subquery
-- SELECT COUNT(DISTINCT e2.salary)
-- FROM Employee e2
-- WHERE e2.departmentId = e.departmentId
--   AND e2.salary > e.salary

-- For each employee, it asks:

-- "Within this employee's department, how many unique salaries are greater than this employee's salary?"

-- Then:

-- 3 > count

-- means the count must be:

-- 0 → highest
-- 1 → second highest
-- 2 → third highest

-- But:

-- 3 → fourth highest ❌
-- 4 → fifth highest ❌

-- So only top 3 unique salaries survive.

-- Dry run for IT
-- Max = 90000

-- Higher unique salaries:

-- none
-- COUNT = 0
-- 3 > 0 → TRUE

-- ✅ Max included.

-- Joe = 85000

-- Higher unique salaries:

-- 90000
-- COUNT = 1
-- 3 > 1 → TRUE

-- ✅ Joe included.

-- Randy = 85000

-- Exactly the same calculation:

-- 90000
-- COUNT = 1

-- ✅ Randy included.

-- Notice why we use:

-- COUNT(DISTINCT e2.salary)

-- Joe and Randy both have 85000, but 85000 should count as one salary level, not two.

-- Will = 70000

-- Higher unique salaries:

-- 90000
-- 85000
-- COUNT = 2
-- 3 > 2 → TRUE

-- ✅ Will included.

-- Janet = 69000

-- Higher unique salaries:

-- 90000
-- 85000
-- 70000
-- COUNT = 3
-- 3 > 3 → FALSE

-- ❌ Janet excluded.

-- The key idea

-- The most important part of this problem is:

-- COUNT(DISTINCT e2.salary)

-- We aren't counting employees.

-- We're counting unique salary levels above the current employee.

-- So:

--                     Current employee
--                            ↓
--                     salary = 70000

-- IT salaries:
-- 90000  ← higher unique salary #1
-- 85000  ← higher unique salary #2
-- 85000  ← same salary, don't count again
-- 70000  ← current
-- 69000

-- Therefore:

-- 2 unique salaries are higher
--         ↓
-- 3rd highest unique salary
--         ↓
--        KEEP

-- This is a very useful pattern to remember:

-- Top K unique values → count how many DISTINCT values are greater than the current value, and require that count < K.