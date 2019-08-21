# SQL

- Foreign_Key will refer to the primary key of a related DATABASES.
- Column headers are considered METADATA. METADATA helps you define the data inside the column.
- "Rule of one" you want to track single entities not, groupings.
- Rows of the database tables are often referred to as tuples. 
- For SQL, we will use the snake_case naming convention.
- SQL is both a data definition language and a data manipulation language.

>Types of relationships
  - ONE TO ONE (ex. Student to Car relationship)
    - defined as the relationship between two tables where both the tables should be associated with each other based on 
      only one matching row.
  - ONE TO MANY (ex. Student to Car, Student to ClassRoom)
      - one record in a table can be associated with one or more records in another table. Parent to child relationship.
  - MANY TO ONE (each city exists in exactly one state, but a state may have many cities, hence the term "many-to-one.")
      - contains values that refer to another entity (a column or set of columns) that has unique values.
  - MANY TO MANY (Often broken down to Two, one to many relationships due to difficulty of supporting)
      - will ALWAYS have bridge entities to help the intersection


>Normalization
  - First Normal Form (1NF) 
    - is satisfied if and only if the domain of each attribute contains only atomic values, and the value of each attribute 
      contains only a single value from that domain.
    - each entity must have a Primary key.
  - Second Normal Form (2NF)
    - requires 1NF to be satisfied 
    - Does not have any non-prime attribute that is functionally dependent on any subset of any candidate key of the relation. 
      A non-prime attribute of a relation is an attribute that is not a part of any candidate key of the relation.
  - Third Normal Form (3NF)
    - requires 1NF & 2NF to be satisfied 
    - Only foreign key columns should be used to reference another table, and no other columns from the parent table should exist 
      in the referenced table.

  *CAVEATS*
    - Each entity must have a primary key (natural or artificial)
    - Every column must only have a single value 
    - All the columns must be related to the primary key (functional dependency)
    - Interdependencies between entity columns must not exist


>SQL Joins
  - Inner Joins
    - returns records that have matching values in both tables.
  - Left Outer Joins 
    - returns all records from the left table (table1), and the matched records from the right table (table2). 
      The result is NULL from the right side, if there is no match.
  - Right Outer Joins
    - returns all records from the right table (table2), and the matched records from the left table (table1). 
      The result is NULL from the left side, when there is no match.
  - Full Join
    - returns all records when there is a match in left (table1) or right (table2) table records.

>Acid Properties
  - ATOMIC 
    - RDBMS will guarantee that a group of statements that run together will either all run or none will run
      this group of statements is called a transaction.
  - Consistency
    - Data entered will not break rules, often called constraints.
  - Isolated
    - RDBMS must be able to control access to data to keep two or more uses from modifying the same data at the
      same time.
    - If not done, this could result in lost updates or dirty reads. 
    - Locking is the most common approach to becoming isolated.
  - Durable
    - even if the server loses power, the committed transactions will be saved

    - Transaction Log
      - most modern RDBMS use it durability and support commits and rollbacks of transactions.
      - stored on disk and keeps a list of all tx applied. 
      - helps the RDBMS be durable 




