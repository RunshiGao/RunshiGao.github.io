package web.servlet;

import dao.UserDao;
import domain.User;
import util.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User regUser = new User();
        UserDao dao = new UserDao();
        regUser.setUsername(username);
        regUser.setPassword(password);
        try {
            Connection con = JDBCUtils.getConnection();
            if(dao.register(con,regUser)){

                response.sendRedirect("login.html");
                response.getWriter().println("注册成功，请登录");
            }else{
                response.sendRedirect("register.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
