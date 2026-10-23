# Write your MySQL query statement below
SELECT si.user_id, 
ROUND(AVG(IF(action = 'confirmed', 1, 0)), 2) AS confirmation_rate
FROM Signups AS si
LEFT JOIN Confirmations AS co
ON si.user_id = co.user_id
GROUP BY user_id;


-- SELECT si.user_id, 
-- ROUND(AVG(IF(action = 'confirmed', 1, 0)), 2)
-- AS confirmation_rate
-- FROM Signups AS si
-- LEFT JOIN Confirmations AS co
-- ON si.user_id = co.user_id
-- GROUP BY user_id;

-- SELECT si.user_id,
-- ROUND(AVG(IF(action = "confirmed", 1, 0)), 2)
-- AS confirmation_rate
-- FROM Signups AS si
-- LEFT JOIN Confirmations AS co
-- ON si.user_id = co.user_id
-- GROUP BY user_id;

