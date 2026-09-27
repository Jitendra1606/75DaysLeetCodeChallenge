# Write your MySQL query statement below
SELECT DISTINCT
l1.Num AS ConsecutiveNums
FROM 
    Logs AS l1,
    Logs AS l2,
    Logs As l3
WHERE
    l1.Id = l2.Id - 1
    AND 
    l2.Id = l3.Id - 1
    AND 
    l1.Num = l2.Num
    AND
    l2.Num = l3.Num
;

-- Yes — exactly. When you write the same table multiple times with different aliases, SQL treats each occurrence as a separate reference to that table.

-- For example:

-- SELECT *
-- FROM Logs l1,
--      Logs l2,
--      Logs l3;

-- Think of it as:

-- Logs → l1
-- Logs → l2
-- Logs → l3

-- They are not three copies of the physical table. It's the same physical table being referenced three times, and SQL can use each reference independently.

-- The important part: Cartesian product

-- If Logs has 3 rows:

-- id	num
-- 1	1
-- 2	2
-- 3	3

-- Then:

-- FROM Logs l1, Logs l2, Logs l3

-- initially produces:

-- 3 × 3 × 3 = 27 rows

-- because SQL considers every possible combination:

-- l1       l2       l3
-- ----------------------
-- row1     row1     row1
-- row1     row1     row2
-- row1     row1     row3
-- row1     row2     row1
-- row1     row2     row2
-- ...
-- row3     row3     row3

-- Then your WHERE condition filters those combinations.

-- For example, this is the classic Consecutive Numbers problem: