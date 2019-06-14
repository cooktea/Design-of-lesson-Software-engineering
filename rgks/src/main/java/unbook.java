import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import util.database.dbUnbook;

@WebServlet(name = "unbook")
public class unbook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        dbUnbook db = new dbUnbook(id);
        response.setContentType("text/html;charset=UTF-8");
        if(db.unBook()){
            response.getWriter().println("退票成功，即将返回订单页");
            response.setHeader("refresh","3;URL=Home.jsp");
        } else {
            response.getWriter().println("退票失败，即将返回订单页");
            response.setHeader("refresh","3;URL=Home.jsp");
        }
    }
}
