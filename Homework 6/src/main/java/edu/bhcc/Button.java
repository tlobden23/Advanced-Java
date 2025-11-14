package edu.bhcc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Button Servlet
 * Simple HTML page that has a header and button to RandomSkin servlet
 */
public class Button extends HttpServlet {

    /**
     * Process an HTTP Request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        // create PrintWriter object
        PrintWriter writer = response.getWriter();

        // HTML CODE using writer
        writer.println("<html>");
        writer.println("<body>");

        // center the header
        writer.println("<h1 style='text-align:center;'>Click the button to see a random CSGO skin</h1>");

        // form to trigger POST request to RandomSkin servlet
        writer.println("<form action='random_skin' method='POST'>");

        // button for user to press for interactivity to generate random skin
        writer.println("<button type='submit' style='display:block; margin:auto; width:300px;'>Press Me</button>");
        writer.println("</form>");

        writer.println("</body>");
        writer.println("</html>");
    }
}
