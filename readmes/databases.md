# Databases

## Overview
A database is an `organised collection of data` (structured information) that is typically stored in a computer system, enabling efficient `access`, `management`, and `retrieval` of data.
There are two types of databases: [relational databases](https://github.com/shumarb/learning/blob/main/readmes/relational-databases.md), and [non-relational databases](https://github.com/shumarb/learning/blob/main/readmes/non-relational-databases.md).

## Key Concepts
### CRUD Operations
CRUD denotes the initials of these four basic operations for managing data in a database:

| Operation | Explanation                                          |
|-----------|------------------------------------------------------|
| Create    | Add data into the database (eg: `INSERT` in SQL).    |
| Read      | Retrieve data in the database (eg: `SELECT` in SQL). |
| Update    | Modify data in the database (eg: `UPDATE` in SQL).   |
| Delete    | Delete data from the database (eg: `DELETE` in SQL). |

### ACID Properties
ACID denotes the initials of key principles for reliable transactions in **relational** databases:

| Property    | Explanation                                                                                                                                         |
|-------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| Atomicity   | All operations in a transaction are successfully completed. If any operation fails, the transaction is aborted, and the database remains unchanged. |
| Consistency | A transaction moves the database from one valid state to another, maintaining integrity.                                                            |
| Isolation   | Transactions are independent and not visible to other transactions until completed.                                                                 |
| Durability  | Once a transaction is completed, its changes are permanent, even in the event of a system failure.                                                  |

### DDL (Data Definition Language)
DDL consists of SQL commands used to define and manage database **schemas**. Common DDL commands include:

| DDL Command | Explanation                       |
|-------------|-----------------------------------|
| CREATE      | Create new tables or databases.   |
| ALTER       | Modify existing database objects. |
| DROP        | Delete tables or databases.       |

### DML (Data Manipulation Language)
DML comprises SQL commands used for managing data within existing **schemas**. Common DML commands include:

| DML Command | Explanation              |
|-------------|--------------------------|
| SELECT      | Retrieve data.           |
| INSERT      | Add new records.         |
| UPDATE      | Modify existing records. |
| DELETE      | Remove records.          |
