-- gpt link - https://chatgpt.com/share/6aaa9c74-bff4-83ee-b1a6-b2aeb1bc884d

# Write your MySQL query statement below

SELECT today.id AS id
FROM Weather AS yesterday
CROSS JOIN Weather AS today

WHERE DATEDIFF(today.recordDate, yesterday.recordDate) = 1 AND today.temperature > yesterday.temperature;


-- SELECT today.id
-- FROM Weather as yesterday
-- CROSS JOIN Weather as today

-- WHERE DATEDIFF(today.recordDate, yesterday.recordDate) = 1 AND today.temperature > yesterday.temperature;