import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import util.database.dbBook;

@WebServlet(name = "bookTicket")
public class bookTicket extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String date = request.getParameter("date");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String seat = request.getParameter("seat");
        String phoneNumber = null;
        Cookie[] cookies = request.getCookies();
        for(int i=0;i<cookies.length;i++){
            if("phoneNumber".equals(cookies[i].getName())){
                phoneNumber = cookies[i].getValue();
            }
        }
        dbBook db = new dbBook(id,date,start,end,phoneNumber,seat);
        if(db.book()){
            response.getWriter().println("预定成功，即将返回订单页");
            response.setHeader("refresh","3;URL=Home.jsp");
        } else {
            response.getWriter().println("预定失败，即将返回首页");
            response.setHeader("refresh","3;URL=index.html");
        }
    }
}
