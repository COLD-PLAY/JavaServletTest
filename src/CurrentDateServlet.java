import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by coldplay on 17-4-11.
 */
public class CurrentDateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CurrentDateServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setIntHeader("refresh", 2);
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String title = "show now's date and time";

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E a");
        String nowtime = df.format(date);
        Integer timestamp = new Integer((int)date.getTime());

        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">" + date.toString() + "</h2>\n" +
                "<h3 align=\"center\">" + nowtime + "</h3>\n" +
                "<h4 align=\"center\">" + timestamp + "</h4>\n" +
                "</body></html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }
}
