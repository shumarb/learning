# Structured Query Language (SQL)

## Overview
SQL (Structured Query Language) is a language for managing relational databases.
It allows users to `query`, `insert`, `update`, and `delete` data, as well as manage a database schema (e.g., creating, altering tables).

## Clauses
### Basic
| Clause   | Explanation                                                                                                     |
|----------|-----------------------------------------------------------------------------------------------------------------|
| SELECT   | Retrieves data from one or more columns in a table.                                                             |
| FROM     | Identifies table to apply SQL on.                                                                               |
| WHERE    | Filters rows before grouping/aggregation occurs, based on a condition.                                          |
| GROUP BY | Groups rows by one or more non-aggregate columns. Applicable when one or more aggregate function is used.       |
| HAVING   | Filters groups after the `GROUP BY` clause. Used to filter results of aggregate functions.                      |
| ORDER BY | Sorts the result set based on one or more columns, either in ascending (`ASC`; default) or descending (`DESC`). |

## Concepts
| Concepts                                                                                               |
|--------------------------------------------------------------------------------------------------------|
| [Aggregate Functions](https://github.com/shumarb/learning/tree/main/databases/sql/aggregate-functions) |
