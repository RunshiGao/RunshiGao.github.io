package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/examServlet")
public class ExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int E=0;
        int I=0;
        int S=0;
        int N=0;
        int T=0;
        int F=0;
        int J=0;
        int P=0;
        int z=1;
        String testRes="";

        while(z<=28){
            String res= request.getParameter("a"+z+"");
            if(res.equals("E")) E++;
            if(res.equals("I")) I++;
            if(res.equals("S")) S++;
            if(res.equals("N")) N++;
            if(res.equals("T")) T++;
            if(res.equals("F")) F++;
            if(res.equals("J")) J++;
            if(res.equals("P")) P++;
            z++;
        }
        response.getWriter().write("您的测试结果为：");
        if(E>I){
            testRes+="E";
        }
        else{
            testRes+="I";
        }
        if(S>N){
            testRes+="S";
        }
        else{
            testRes+="N";
        }
        if(T>F){
            testRes+="T";
        }
        else{
            testRes+="F";
        }
        if(J>P){
            testRes+="J";
        }
        else{
            testRes+="P";
        }
        request.setAttribute("testResult",testRes);
        request.getRequestDispatcher("/index.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
