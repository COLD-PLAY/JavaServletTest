import com.myorg.MyServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by coldplay on 17-4-15.
 */
public class ImportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ImportServlet() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String message;
        try {
            MyServlet myserlvet = new MyServlet("liao zhou is here");
            message = myserlvet.get_message();
        } catch (Exception e) {
            message = e.getMessage();
        }

        out.print("<h1> " + message + "</h1>");

    }


}
