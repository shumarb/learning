# Databases

## Overview
A database is an organised collection of data (structured information) that is typically stored in a computer system. It allows for easy access, management, and retrieval of data.
There are two types of databases: [relational databases](https://github.com/shumarb/learning/tree/main/databases/relational-databases), and [non-relational databases](https://github.com/shumarb/learning/tree/main/databases/non-relational-databases).

## Key Concepts
### CRUD Operations
CRUD denotes the initials of these four basic operations for managing data in a database:
- **Create**: Adding data into the database (eg: `INSERT` in SQL).
- **Read**: Retrieving data in the database (eg: `SELECT` in SQL).
- **Update**: Modifying data in the database (eg: `UPDATE` in SQL). 
- **Delete**: Deleting data from the database (eg: `DELETE` in SQL).

### ACID Properties
ACID denotes the initials of key principles for reliable transactions in **relational** databases:
- **Atomicity**: Ensures that all operations within a transaction are completed. If any operation fails, the transaction is aborted, and the database remains unchanged.
- **Consistency**: Ensures that a transaction brings the database from one valid state to another.
- **Isolation**: Ensures that transactions are not visible to other transactions until the transaction is complete.
- **Durability**: Guarantees that once a transaction is complete, the changes it made will persist in the database, even in the event of a system failure.

### DDL (Data Definition Language)
DDL consists of SQL commands used to define and manage database **schemas**. Common DDL commands include:
- **CREATE**: To create new tables or databases.
- **ALTER**: To modify existing database objects.
- **DROP**: To delete tables or databases.

### DML (Data Manipulation Language)
DML comprises of SQL commands used for managing data within existing **schemas**. Common DML commands include:
- **SELECT**: To retrieve data.
- **INSERT**: To add new records.
- **UPDATE**: To modify existing records.
- **DELETE**: To remove records.
