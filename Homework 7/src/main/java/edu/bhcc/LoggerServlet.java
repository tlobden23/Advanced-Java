package edu.bhcc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet responsible for handling request.
 *
 */
public class LoggerServlet extends HttpServlet {

    private LogDatabase logDatabase = new LogDatabase();

    /**
     * This method retrieves message and then inserts into database and then puts in HashMap to be displayed.
     *
     * @param request
     * @param response
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        // read message from query string
        String message = request.getParameter("message");

        // insert into database if message isn't null
        if (message != null) {
            // insert into database
            logDatabase.insert(message.trim());
        }

        // HashMap to create model
        Map<String, Object> model = new HashMap<>();
        model.put("row", logDatabase.retrieve());

        // Get the FreeMarker Template Engine
        FreeMarkerUtil setup = FreeMarkerUtil.getInstance();
        Configuration cfg = setup.getFreeMarkerConfiguration();
        Template template = cfg.getTemplate("logger.html");

        // merge the model with the template
        PrintWriter writer = response.getWriter();
        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            writer.println("Could not process template:  " + e.getMessage());
        }
    }
}