# SQL - Aggregate Functions

## Overview
Aggregate functions act on sets of data.
When an aggregate function is applied, the `GROUP BY` clause must be specified in the query,
and it must list all non-aggregate functions that are not part of the primary key.

## Aggregate Functions
| Aggregate Function | Description                            | Column Data Type    |
|--------------------|----------------------------------------|---------------------|
| COUNT              | Counts the number of entries in a set. | All.                |
| SUM                | Adds all values in a set.              | INT.                |
| AVG                | Computes average value of a set.       | INT.                |
| MAX                | Returns maximum value in a set.        | INT, VARCHAR, DATE. |
| MIN                | Returns minimum value in a set.        | INT, VARCHAR, DATE. |

## Example
Consider the `gamers` table:

| username (Primary Key) | name          | email_address             | age |
|------------------------|---------------|---------------------------|-----|
| waynetan12             | Wayne Tan     | waynetan@gmail.com        | 20  |
| eric_sam               | Wayne Tan     | waynetan@gmail.com        | 20  |
| syedali                | Syed Ali      | syed_ali@icloud.com       | 45  |
| nabil_luqman           | Nabil Luqman  | nabil_luqman@gmail.com    | 24  |
| farouk_hassan13        | Farouk Hassan | farouk_hassan@outlook.com | 49  |

Q: Display all duplicates email addresses:
```sql
SELECT email_address, COUNT(*)
FROM gamers
GROUP BY email_address, 
HAVING COUNT(*) > 1;
```
Q: Find the total number of gamers with email addresses from gmail:
```sql
SELECT email_address, COUNT(*)
FROM gamers
WHERE email_address LIKE '%gmail.com'
GROUP BY email_address
HAVING COUNT(*) > 1;
```