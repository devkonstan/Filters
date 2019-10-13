package EvenNotEven;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/modulo")
public class ModuloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        int number = Integer.parseInt(servletRequest.getParameter("num"));
        if (number % 2 == 0) {
            servletResponse.getWriter().println("Even number: " + number);
            return;
        }
        try {
            int value = Integer.parseInt(String.valueOf(number));
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (NumberFormatException e) {
            servletResponse.getWriter().println("This is not a number!!!!");
        }

    }

    @Override
    public void destroy() {

    }
}

