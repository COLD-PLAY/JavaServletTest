import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by coldplay on 17-4-10.
 */
@WebServlet("/ShowErrorServlet")
public class ShowErrorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ShowErrorServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.sendError(407, "no permission");
    }
}
