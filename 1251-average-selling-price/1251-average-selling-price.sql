# Write your MySQL query statement below
SELECT p.product_id, 
ROUND(COALESCE(SUM(p.price * uni.units) / SUM(uni.units), 0), 2)
AS average_price FROM Prices As p
LEFT JOIN UnitsSold AS uni
ON p.product_id = uni.product_id
AND uni.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY product_id;


-- SELECT p.product_id,
-- ROUND(COALESCE(SUM(p.price * u.units) / SUM(u.units), 0), 2)
-- AS average_price FROM Prices AS p
-- LEFT JOIN UnitsSold AS u
-- ON p.product_id = u.product_id
-- AND u.purchase_date BETWEEN p.start_date AND p.end_date
-- GROUP BY p.product_id;


-- SELECT  
--     p.product_id,
--     ROUND(
--         COALESCE(SUM(p.price * u.units) / SUM(u.units), 0),
--         2
--     ) AS average_price
-- FROM prices AS p
-- LEFT JOIN unitsSold as u
--     ON p.product_id = u.product_id
--     AND u.purchase_date BETWEEN p.start_date AND p.end_date
-- GROUP BY p.product_id;


-- 1. What actually happens first?

-- Think of it like this:

-- FROM prices p
--        ↓
-- LEFT JOIN unitsSold u
--        ↓
-- ON conditions are checked
--        ↓
-- Joined table is created
--        ↓
-- GROUP BY product_id
--        ↓
-- SUM() calculations
--        ↓
-- SELECT
--        ↓
-- ROUND()

-- So the calculation is NOT actually happening before the JOIN.