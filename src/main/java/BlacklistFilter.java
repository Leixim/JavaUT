import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class BlacklistFilter implements Filter {

    public BlacklistFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ipAddress = servletRequest.getRemoteAddr();
        PrintWriter printWriter = servletResponse.getWriter();
        try {
            if (!Reader.readSplitIPFromFile().contains(ipAddress)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                printWriter.print("Access disallowed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
