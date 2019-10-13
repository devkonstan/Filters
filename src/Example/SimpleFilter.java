package Example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(servletNames = "simpleServletName")
public class SimpleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("before");
        request.setAttribute("simpleServletAttribute", "simpleServlet");
        chain.doFilter(request, response);
        System.out.println("after");
    }

    @Override
    public void destroy() {
    }
}