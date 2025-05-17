WITH daily_amount AS (
    -- Sum amount per day
    SELECT
        visited_on,
        SUM(amount) AS total_amount
    FROM Customer
    GROUP BY visited_on
)

SELECT
    d1.visited_on,
    -- Sum over the last 7 days (including current day)
    SUM(d2.total_amount) AS amount,
    ROUND(SUM(d2.total_amount) / 7, 2) AS average_amount
FROM daily_amount d1
JOIN daily_amount d2
    ON d2.visited_on BETWEEN DATE_SUB(d1.visited_on, INTERVAL 6 DAY) AND d1.visited_on
GROUP BY d1.visited_on
HAVING COUNT(DISTINCT d2.visited_on) = 7 -- ensure 7 days of data
ORDER BY d1.visited_on;
