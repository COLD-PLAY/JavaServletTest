import javax.servlet.*;
import java.io.IOException;

/**
 * Created by coldplay on 17-4-11.
 */
public class SiteHitCounter implements Filter {
    private int hitCount;

    public void init(FilterConfig config)
        throws ServletException {
        hitCount = 0;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws ServletException, IOException {
        hitCount++;

        System.out.println("网站访问统计： " + hitCount);

        chain.doFilter(request, response);
    }

    public void destroy() {
        // write hitCount to database
    }
}
