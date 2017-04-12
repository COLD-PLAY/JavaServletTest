import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by coldplay on 17-4-10.
 */
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UploadServlet() {
        super();
    }

    private static final String UPLOAD_DIRECTORY = "/home/coldplay/Desktop/upload";

    private static final int MEMORY_THRESHOLD = 1024*1024*30; // 30MB
    private static final int MAX_FILE_SIZE = 1024*1024*40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024*1024*50; // 50MB

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();

            writer.println("Error: form must include enctype=multipart/from-data");
            writer.flush();
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
//        set the save top
        factory.setSizeThreshold(MEMORY_THRESHOLD);
//        set the temple dir to save the file
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        upload.setHeaderEncoding("UTF-8");

//        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        String uploadPath = UPLOAD_DIRECTORY;

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
//                    System.out.println(item.getName());
                    String fileName = new File(item.getName()).getName();
                    String filePath = uploadPath + File.separator + fileName;
                    File storeFile = new File(filePath);

                    System.out.println(filePath);
                    item.write(storeFile);
                    request.setAttribute("message", "upload file successfully!".toUpperCase());
                }
            }
        } catch(Exception e) {
            request.setAttribute("message", "error info: " + e.getMessage());
        }
        request.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
    }
}
