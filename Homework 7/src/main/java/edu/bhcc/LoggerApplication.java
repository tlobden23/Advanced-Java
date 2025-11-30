package edu.bhcc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoggerApplication extends HttpServlet {

    private LogDatabase db;

    @Override
    public void init() {
        db = new LogDatabase();
        db.init();   // create table if needed
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String path = request.getPathInfo();

        // Example: /logger/log_message
        if ("/log_message".equals(path)) {
            handleInsert(request, response);
            return;
        }

        // Otherwise show the main page
        showPage(response);
    }

    private void handleInsert(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {

        String message = request.getParameter("message");

        if (message != null && !message.trim().isEmpty()) {
            db.insert(message.trim());
        }

        response.sendRedirect(request.getContextPath() + "/logger");
    }

    private void showPage(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<Log> logs = db.findAll();

        StringBuilder sb = new StringBuilder();
        for (Log log : logs) {
            sb.append("<div class=\"row\">")
                    .append("<div class=\"col-4 pe-0 border-bottom py-2\">")
                    .append(log.getTimeStamp())
                    .append("</div>")
                    .append("<div class=\"col-3 ps-0 border-bottom py-2\">")
                    .append(log.getMessage())
                    .append("</div>")
                    .append("</div>");
        }

        Map<String, Object> model = new HashMap<>();
        model.put("rows", sb.toString());

        Configuration cfg = FreeMarkerUtil.getInstance().getFreeMarkerConfiguration();
        Template tpl = cfg.getTemplate("logger.html");

        PrintWriter out = response.getWriter();
        try {
            tpl.process(model, out);
        } catch (TemplateException e) {
            out.println("Template error: " + e.getMessage());
        }
    }
}
