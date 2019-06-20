import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import util.database.dbUser;


@WebServlet(name = "deleteUser")
public class deleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        response.setContentType("text/html;charset:UTF-8");

        dbUser db = new dbUser();
        if(db.deleteUser(id)){
            response.getWriter().println("删除完成，即将返回");
            response.setHeader("refresh","3,URL=manageUser.jsp");
        } else {
            response.getWriter().println("删除失败，即将返回");
            response.setHeader("refresh","3,URL=manageUser.jsp");
        }
    }
}
