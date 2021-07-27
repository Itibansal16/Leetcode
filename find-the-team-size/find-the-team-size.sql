# Iti

# (employee_id, team_id) and (team_id, count(team_id))

# SELECT team_id, COUNT(*) AS team_size FROM Employee GROUP BY team_id

# SELECT Employee_id, tc.team_size
# FROM Employee e LEFT JOIN 
# (SELECT team_id, COUNT(*) AS team_size FROM Employee GROUP BY team_id) AS tc
# ON e.team_id = tc.team_id;

SELECT employee_id, tc.team_size
FROM Employee e JOIN
(Select team_id, COUNT(*) AS team_size FROM Employee GROUP BY team_id) AS tc
ON e.team_id = tc.team_id;