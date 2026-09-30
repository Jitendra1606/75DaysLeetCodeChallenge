# Write your MySQL query statement below
SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016
FROM Insurance
WHERE tiv_2015 IN (
    SELECT tiv_2015
    FROM Insurance
    GROUP BY tiv_2015
    HAVING COUNT(*) > 1
) 

AND (lat, lon) IN (
    SELECT lat, lon 
    FROM Insurance
    GROUP BY lat, lon
    HAVING COUNT(*) = 1
);





-- Step 1 — Find repeated tiv_2015
-- SELECT tiv_2015
-- FROM Insurance
-- GROUP BY tiv_2015
-- HAVING COUNT(*) > 1

-- Suppose:

-- tiv_2015
-- 10
-- 20
-- 20
-- 30
-- 30
-- 30

-- Result:

-- tiv_2015
-- 20
-- 30

-- So we only want policies whose tiv_2015 is 20 or 30.

-- Step 2 — Find unique locations
-- SELECT lat, lon
-- FROM Insurance
-- GROUP BY lat, lon
-- HAVING COUNT(*) = 1

-- Suppose:

-- lat	lon
-- 10	20
-- 11	21
-- 10	20
-- 15	25

-- Result:

-- lat	lon
-- 11	21
-- 15	25

-- Notice why we use:

-- GROUP BY lat, lon

-- We consider the combination (lat, lon) as the location.

-- Step 3 — Apply both conditions

-- Now:

-- WHERE tiv_2015 IN (...)
-- AND (lat, lon) IN (...)

-- means:

-- Keep the policy only if its tiv_2015 is duplicated AND its (lat, lon) combination is unique.

-- Then:

-- SUM(tiv_2016)

-- adds their 2016 values.

-- And:

-- ROUND(..., 2)

-- gives the required 2 decimal places.

-- One thing to remember for LC 585

-- There are two completely independent conditions:

--                     Insurance
--                        │
--              ┌─────────┴─────────┐
--              ↓                   ↓
--        tiv_2015 repeated    (lat,lon) unique
--        COUNT > 1            COUNT = 1
--              │                   │
--              └─────────┬─────────┘
--                        ↓
--                   take tiv_2016
--                        ↓
--                       SUM

-- Your instinct to use a self-join is understandable, but for this problem, two GROUP BY subqueries are much easier to reason about.

-- i don't get for lat and lon part

-- Yes — this part is the tricky part. Let's ignore the tiv_2015 condition completely and understand only lat, lon.

-- What does "location is unique" mean?

-- In LC 585, a policy's location is represented by both:

-- (lat, lon)

-- For example:

-- pid	lat	lon
-- 1	10	20
-- 2	10	20
-- 3	15	25
-- 4	30	40

-- Think of (10,20) as one location.

-- So:

-- Policy 1 → location (10,20)
-- Policy 2 → location (10,20)
-- Policy 3 → location (15,25)
-- Policy 4 → location (30,40)
-- Which locations are unique?

-- (10,20) appears twice ❌

-- (15,25) appears once ✅

-- (30,40) appears once ✅

-- Therefore we want:

-- (15,25)
-- (30,40)
-- How does SQL find this?

-- We write:

-- SELECT lat, lon
-- FROM Insurance
-- GROUP BY lat, lon
-- HAVING COUNT(*) = 1;

-- The important part is:

-- GROUP BY lat, lon

-- This means:

-- "Group rows having the same latitude AND same longitude."

-- Let's dry run it.

-- Suppose:

-- pid	lat	lon
-- 1	10	20
-- 2	10	20
-- 3	15	25
-- 4	30	40
-- 5	15	25
-- 6	50	60

-- After:

-- GROUP BY lat, lon

-- SQL creates these groups:

-- (10,20) → 2 rows

-- (15,25) → 2 rows

-- (30,40) → 1 row

-- (50,60) → 1 row

-- Then:

-- HAVING COUNT(*) = 1

-- keeps only:

-- (30,40)
-- (50,60)

-- because those locations occur exactly once.

-- Why can't we do this?

-- You might be thinking:

-- GROUP BY lat

-- No ❌

-- Because latitude alone doesn't identify a location.

-- For example:

-- pid	lat	lon
-- 1	10	20
-- 2	10	50

-- These are different locations:

-- (10,20)
-- (10,50)

-- They happen to have the same latitude.

-- So GROUP BY lat would incorrectly put them together.

-- Similarly:

-- GROUP BY lon

-- is also wrong.

-- Think of (lat, lon) as one value

-- This is the easiest way to remember it.

-- Don't think:

-- lat
-- lon

-- Think:

--         location
--            ↓
--        (lat, lon)

-- For example:

-- (10,20)
-- (10,50)
-- (15,20)

-- These are three different locations.

-- So:

-- GROUP BY lat, lon

-- means:

-- Group by the complete location.

-- Now your original JOIN becomes clearer

-- You had:

-- ON a.tiv_2015 = b.tiv_2015

-- You were trying to check:

-- a.lat <> b.lat
-- AND
-- a.lon <> b.lon

-- But this doesn't correctly express unique (lat,lon).

-- For example:

-- a = (10,20)
-- b = (10,50)

-- Locations are different, but:

-- a.lat <> b.lat → 10 <> 10 → FALSE

-- So your condition fails.

-- The actual requirement isn't:

-- "Find another row whose latitude AND longitude are different."

-- It is:

-- "Make sure no other row has the exact same (lat, lon) combination."

-- That's why this is much cleaner:

-- GROUP BY lat, lon
-- HAVING COUNT(*) = 1
-- One-line memory trick

-- If two columns together represent one thing, GROUP BY both columns.

-- Here:

-- (lat + lon) = location

-- therefore:

-- GROUP BY lat, lon

-- That's the entire lat/lon part.