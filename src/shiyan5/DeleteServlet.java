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
import java.io.UnsupportedEncodingException;

@WebServlet(name = "delete",urlPatterns = "/deleteServlet")
public class DeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
    public  void  doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //获取超链接上传入id值，根据获取的id值调用删除方法从数据库中删除信息
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        System.out.println(id);
        score_deal sdl=new score_deal();
        sdl.DeleteScores(Integer.parseInt(id));
        request.getRequestDispatcher("/show_scoreServlet").forward(request,response);
    }

}
