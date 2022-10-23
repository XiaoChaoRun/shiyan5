package shiyan5;
/*
 Create by 2022 10.16
 @author  李超
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateServlet",urlPatterns = "/updateServlet")
public class updateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
    public  void  doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //获取修改的学生成绩信息，调用UpdateScores()方法修改
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("stu_id");
        String name=request.getParameter("stu_name");
        String webscores=request.getParameter("web");
        String javascores=request.getParameter("java");
        String osscores=request.getParameter("os");
        System.out.println("姓名:"+name);
        System.out.println("web成绩"+webscores);
        score_deal sdl=new score_deal();
        sdl.UpdateScores(Integer.parseInt(id),name,Integer.parseInt(webscores),Integer.parseInt(javascores),Integer.parseInt(osscores));
        request.getRequestDispatcher("/show_scoreServlet").forward(request,response);
    }

}
