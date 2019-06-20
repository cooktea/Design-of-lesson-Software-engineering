import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import util.database.dbAddSeat;


@WebServlet(name = "addseat")
public class addseat extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String seat = request.getParameter("seat");
        String time = request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day");
        String number = request.getParameter("number");
        String route = request.getParameter("route");
        dbAddSeat db = new dbAddSeat();
        if(db.addSeat(route,time,seat,number)){
            response.getWriter().println("修改成功，即将返回管理主页面");
            response.setHeader("refresh","3,url=manager.html");
        } else {
            response.getWriter().println("修改失败，即将返回管理主页面");
            response.setHeader("refresh","3,url=manager.html");
        }
    }
}
