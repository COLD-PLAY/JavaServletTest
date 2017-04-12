import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by coldplay on 17-4-11.
 */
public class PageHitCounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int hitCount;

    public PageHitCounterServlet() {
        super();
    }

    public void init() {
        hitCount = 0;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        hitCount++;
        PrintWriter out = response.getWriter();

        String title = "total hit count";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
        "<html>\n" +
        "<head><title>" + title + "</title><head>\n" +
        "<body bgcolor=\"#f0f0f0\">\n" +
        "<h1 align=\"center\">" + title + "</h1>\n" +
        "<h2 align=\"center\">" + hitCount + "</h2>\n" +
        "</body></html>");
    }
    public void destroy() {
        // write hitCount to database
    }
}
