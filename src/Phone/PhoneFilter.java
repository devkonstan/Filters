package Phone;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/phone")
public class PhoneFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String phone = servletRequest.getParameter("phoneNum");
        if (phone != null && phone.startsWith("48") && phone.length()==11) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.getWriter().println("Not a valid phone number!!!!");
        }

    }

    @Override
    public void destroy() {

    }
}