-- gpt sol link- https://chatgpt.com/share/6aaa9908-5a80-83e8-b903-e080ba5ecbe8

# Write your MySQL query statement below
SELECT v.customer_id AS customer_id,
       COUNT(customer_id) AS count_no_trans
FROM Visits AS v
LEFT JOIN Transactions AS t
USING(visit_id) 
WHERE t.visit_id IS NULL
GROUP BY customer_id;



-- SELECT customer_id, COUNT(customer_id) AS count_no_trans
-- FROM Visits AS v
-- LEFT JOIN Transactions AS t
-- USING(visit_id) WHERE t.visit_id IS NULL
-- GROUP BY customer_id;