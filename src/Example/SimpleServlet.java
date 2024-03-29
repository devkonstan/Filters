package Example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/simpleServlet", name = "simpleServletName")
public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter responseWriter = resp.getWriter();
        responseWriter.write("<html><body>");
        Enumeration<String> attributeNames = req.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = req.getAttribute(attributeName);
            responseWriter.write("<p>" + attributeName + ": " + attributeValue + "</p>");
        }
        responseWriter.write("</html></body>");
    }
}