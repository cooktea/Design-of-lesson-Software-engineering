import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import util.database.dbLogin;

@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idCardNumber = request.getParameter("name");
        String pwd = request.getParameter("password");
        //验证管理员登陆
        if(idCardNumber.length() <10){
            //写死的管理员账号,懒得改数据库了
            if("root".equals(idCardNumber) && "123456".equals(pwd)){
                response.getWriter().println("管理员登陆成功，3秒后跳转至管理界面。");
                response.setHeader("refresh","3,URL=manager.html");
                return;
            }
        }
        dbLogin db = new dbLogin(idCardNumber,pwd);
        String number = db.login();
        if(number == null){
            response.getWriter().println("登陆失败，请检查登陆信息是否正确，3秒后返回。");
            response.setHeader("refresh","3;URL=login.html");
        } else {
            Cookie cookie = new Cookie("phoneNumber",number);
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);
            response.getWriter().println("登陆成功，3秒后跳转至车次查询页面");
            response.setHeader("refresh","3,URL=index.html");
        }
    }
}
