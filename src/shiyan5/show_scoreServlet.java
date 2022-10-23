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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "show_score",urlPatterns = "/show_scoreServlet")
public class show_scoreServlet extends HttpServlet {
    private Connection connection=null;
    private Statement statement=null;
    private ResultSet resultSet=null;
    private int pageNow=1;
    private int pageCount=0;
    private int rowCount=0;
    private int pageSize=3;


    public  void  doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException{
        score_deal sdl=new score_deal();
        rowCount=sdl.getRowCont();
        pageCount=sdl.getPageCount(pageSize,rowCount);
        String sql="";
        String currentPage=request.getParameter("pageNow");
        if (currentPage==null){
            currentPage="1";
        }
        pageNow=Integer.parseInt(currentPage);
        //根据当前页面pageNow来决定在数据库中查询的记录范围
        if (pageNow>1){
            sql="select * from stu_score limit " +(pageNow-1)*pageSize+","+pageSize;
            System.out.println(sql);
        }
        else {
            sql="select * from stu_score order by id limit "+pageSize;
            System.out.println(sql);
        }

        ArrayList al=sdl.showSelectResult(sql);
        System.out.println(al);
        request.setAttribute("selresult",al);
        request.setAttribute("pageNow",pageNow);
        request.setAttribute("rowCount",rowCount);
        request.setAttribute("pageCount",pageCount);
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("/show_select.jsp");
        requestDispatcher.forward(request,response);
    }
}