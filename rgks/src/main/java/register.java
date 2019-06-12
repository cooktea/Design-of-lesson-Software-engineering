import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import util.database.dbRegister;

@WebServlet(name = "register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idCardNumber = request.getParameter("idCardNumber");
        String passwd = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        System.out.println(idCardNumber+" "+passwd+" "+phoneNumber);
        dbRegister db = new dbRegister(idCardNumber,passwd,phoneNumber);
        if(db.register()){
            response.getWriter().println("注册成功，3秒后跳转至登陆页面。");
            response.setHeader("refresh","3; URL=login.html");
        } else {
            response.getWriter().println("注册失败，3秒后返回。");
            response.setHeader("refresh","3,register.html");
        }
    }
}
