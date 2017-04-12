import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by coldplay on 17-4-11.
 */
public class PageRedirectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PageRedirectServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String site = "http://www.baidu.com";

//        request.setAttribute("message", "redirect from PageRedirectServlet".toUpperCase());
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
//        response.sendRedirect(site);
    }
}
