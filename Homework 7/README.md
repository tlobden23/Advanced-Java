# Jetty Web Application Template

This project is a simple servlet-based logging application that uses
Jetty, FreeMarker, JDBC, and SQLite.

The application allows a user to submit log messages, which are saved in
a SQLite database and displayed on the page with timestamps.

To run the server:
mvn jetty:run

Then open a browser and use this url:
http://localhost:8080/logger