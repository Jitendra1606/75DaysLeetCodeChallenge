SELECT user_id, name, mail
FROM users
WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode.com$'
AND mail LIKE BINARY '%@leetcode.com';


-- SELECT 
--     user_id, 
--     name, 
--     mail
-- FROM 
--     users
-- WHERE 
--     mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$'
--     AND mail LIKE BINARY '%@leetcode.com';

-- Binary -> This is a MySQL concept, not a regex concept.

-- You had:

-- mail LIKE BINARY '%@leetcode.com'

-- Normally, MySQL's string comparison can be case-insensitive, depending on the column's collation.

-- For example, this might match:

-- abc@leetcode.com
-- abc@LeetCode.com
-- abc@LEETCODE.COM

-- But:

-- LIKE BINARY

-- forces a case-sensitive byte-level comparison.

-- So:

-- mail LIKE BINARY '%@leetcode.com'

-- means:

-- Match exactly @leetcode.com with this capitalization.

-- Therefore:

-- abc@leetcode.com   → ✅
-- abc@LeetCode.com   → ❌
-- abc@LEETCODE.com   → ❌
-- Why was BINARY used in the LeetCode problem?

-- Because the problem requires the domain to be exactly:

-- @leetcode.com

-- with lowercase letters.