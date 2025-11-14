Description:
This project contains two servlets: a home page servlet that displays a simple heading and a button, 
and a second servlet that generates a random number from 1 to 4 and displays a corresponding CSGO skin image with a 
matching description. Clicking the button on the home page sends a POST request to the random-image servlet, which selects 
and outputs one of four possible images.

To run the server

mvn jetty:run

Then open your browser and go to:

http://localhost:8080/button
