package web.servlet;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String u = request.getParameter("username");
        String p = request.getParameter("password");
        User loginUser = new User();
        loginUser.setUsername(u);
        loginUser.setPassword(p);
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        if(user==null){
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }
        else{
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
