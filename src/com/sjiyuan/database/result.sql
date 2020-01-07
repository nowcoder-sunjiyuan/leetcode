# 175
SELECT p.firstname,p.lastname,a.city,a.state FROM person p LEFT JOIN address a ON p.personid = a.personid;

# 176
## 方法一
SELECT MAX(salary) SecondHighestSalary FROM employee WHERE salary!=(SELECT MAX(salary) FROM employee);
## 方法二(mysql)
SELECT COALESCE((SELECT DISTINCT salary FROM employee ORDER BY salary DESC LIMIT 1 OFFSET 1), NULL) AS SecondHighestSalary;

# 177
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT ifnull((SELECT DISTINCT salary FROM employee ORDER BY salary DESC LIMIT N,1), NULL)
  );
END

# 178
select a.score score,( select count(distinct(score)) from scores b where b.score >= a.score ) as rank from scores a order by score desc;

# 180
SELECT distinct(l1.num) AS ConsecutiveNums
FROM logs l1, logs l2, logs l3
WHERE l1.id = l2.id - 1 AND l2.id = l3.id - 1 AND l1.num = l2.num AND l2.num = L3.num;


