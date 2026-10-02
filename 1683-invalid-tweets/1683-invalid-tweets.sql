# Write your MySQL query statement below
SELECT tweet_id 
FROM Tweets
WHERE CHAR_LENGTH(content) > 15;

-- SELECT tweet_id FROM Tweets
-- WHERE CHAR_LENGTH(content) > 15;

#LENGTH() returns the length of the string measured in bytes.
#CHAR_LENGTH() returns the length of the string measured in characters.