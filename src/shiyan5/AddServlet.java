package shiyan5;
/*
 Create by 2022 10.16
 @author  李超
 */
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "add",urlPatterns = "/AddServlet")
public class AddServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    public  void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //获取要增加的学生的信息，调用AddScores()方法新增学生信息。
        String stu_id=request.getParameter("stu_id");
        String stu_name=request.getParameter("stu_name");
        String name = new String(stu_name.getBytes("iso-8859-1"),"utf-8");
        System.out.println(name);
        String web=request.getParameter("web");
        String java=request.getParameter("java");
        String os=request.getParameter("os");
        score_deal scd=new score_deal();
        scd.AddScores(Integer.parseInt(stu_id),name, Integer.parseInt(web), Integer.parseInt(java), Integer.parseInt(os));
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("/show_scoreServlet");
        requestDispatcher.forward(request,response);
    }
}
