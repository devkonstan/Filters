package Number;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/number")
public class NumFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String number = servletRequest.getParameter("num");
        if (number == null) {
            servletResponse.getWriter().println("No number!!!!");
            return;
        }
        try {
            int value = Integer.parseInt(number);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (NumberFormatException e) {
            servletResponse.getWriter().println("This is not a number!!!!");

        }

    }

    @Override
    public void destroy() {

    }
}