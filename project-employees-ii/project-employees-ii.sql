# Write your MySQL query statement below
SELECT project_id FROM Project
GROUP BY project_id
HAVING COUNT(project_id) >= ALL(SELECT (COUNT(project_id)) FROM Project GROUP BY project_id);
