# Write your MySQL query statement below
SELECT p.product_name AS product_name,
       s.year,
       s.price
FROM Sales AS s
LEFT JOIN Product AS p
ON s.product_id = p.product_id;



-- SELECT p.product_name AS product_name, s.year AS year, s.price AS price
-- FROM Sales AS s
-- LEFT JOIN Product AS p
-- ON s.product_id = p.product_id;

-- hme ye dekhna h ki join krwa kis basis pr rha h aur ky ky print krwa rha h bs