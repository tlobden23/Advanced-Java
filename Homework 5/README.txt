Description:
This program creates a database called "music.db" and queries the database.
CreateInsert.java creates a table "MUSIC" and takes in input from terminal to  add song records.
Query.java allows the user to search records by column and condition.

SQL Table:
CREATE TABLE IF NOT EXISTS MUSIC (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    artist TEXT NOT NULL,
    album TEXT NOT NULL,
    release_year INTEGER NOT NULL
);

How to Run:
1. Run CreateInsert.java to create and insert records.
2. Run Query.java to search or count records.
3. Type ‘q’ or ‘quit’ (in any case) to exit.