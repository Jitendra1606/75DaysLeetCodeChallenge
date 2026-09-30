-- gpt link -> https://chatgpt.com/share/6abc96d4-8b84-83ee-96a5-9e536a3175f6
# Write your MySQL query statement below
SELECT a.visited_on AS visited_on,
       SUM(b.day_sum) AS amount,
       ROUND(AVG(b.day_sum), 2) AS average_amount

FROM 
       (SELECT visited_on, SUM(amount) AS day_sum
       FROM Customer
       GROUP BY visited_on) AS a,

       (SELECT visited_on, SUM(amount) AS day_sum
       FROM Customer
       GROUP BY visited_on) AS b

WHERE DATEDIFF(a.visited_on, b.visited_on) BETWEEN 0 AND 6
GROUP BY a.visited_on
HAVING COUNT(b.visited_on) = 7;


-- Why GROUP BY a.visited_on?

-- After the WHERE, we might have something like:

-- a.visited_on	b.visited_on	b.day_sum
-- Jan 7	Jan 1	300
-- Jan 7	Jan 2	200
-- Jan 7	Jan 3	300
-- Jan 7	Jan 4	400
-- Jan 7	Jan 5	250
-- Jan 7	Jan 6	350
-- Jan 7	Jan 7	500

-- There are 7 rows for Jan 7.

-- But our final answer needs one row for Jan 7.

-- So:

-- GROUP BY a.visited_on

-- combines those 7 rows into one group:

-- Jan 7
--     ↓
-- Jan 1 amount
-- + Jan 2 amount
-- + Jan 3 amount
-- + ...
-- + Jan 7 amount