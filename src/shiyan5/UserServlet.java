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
import java.rmi.ServerException;

@WebServlet(name = "userservlet",urlPatterns = "/LiChaoUserServlet")
public class UserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException {

    }

    public  void doPost(HttpServletRequest request,HttpServletResponse response) throws  IOException, ServletException {
        String uesrname=request.getParameter("username");
        String password=request.getParameter("password");
        String passwordtwo=request.getParameter("passwordtwo");
        String operate=request.getParameter("operate");
        LiChaoUserDAO lcud=new LiChaoUserDAO();
        //根据页面返回的operate的值，判断是登录的请求，还是注册的请求
        if (operate.equals("login")){
            if (lcud.LoginUser(uesrname,password)) {
                request.setAttribute("username", uesrname);
                RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
                rd.forward(request,response);
            }
            else {
                request.setAttribute("message","账号不存在或密码错误，请检查");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request,response);
            }
        }
        if (operate.equals("registor")){
            if (password.equals(passwordtwo)){
                System.out.println("两次密码比对成功");
                if (lcud.RegistorUser(uesrname,password)){
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request,response);
                }
                else {
                    System.out.println("插入失败");
                }
            }
            else {
                request.setAttribute("message","两次密码输入不一致，请检查");
                RequestDispatcher rd = request.getRequestDispatcher("registor.jsp");
                rd.forward(request,response);
            }

        }



    }
}
