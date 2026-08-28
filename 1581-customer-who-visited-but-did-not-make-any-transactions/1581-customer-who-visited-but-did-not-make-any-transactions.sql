# Write your MySQL query statement below
SELECT customer_id, count(customer_id) AS count_no_trans
FROM Visits AS v
LEFT JOIN Transactions AS t 
USING(visit_id) WHERE t.visit_id IS NULL
GROUP BY customer_id;