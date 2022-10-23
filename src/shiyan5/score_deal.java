package shiyan5;

/*
   Create time:  2022/10/15
   Author:  李超
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class score_deal {
    private Connection conn=null;
    private Statement stamt=null;
    private ResultSet rs=null;


    public int getRowCont(){  //获取成绩信息表中的列数
        int rowcount=0;
        String sql="select count(*) from stu_score";
        try
        {
            conn=new DBManager().getConnection();
            stamt=conn.createStatement();
            rs=stamt.executeQuery(sql);
            while (rs.next()){
                rowcount=rs.getInt(1);
            }
            System.out.println("获取分页参数成功");
            rs.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rowcount;
    }

    public int getPageCount(int pagesize,int rowcount){   //计算应该分页的数量
        int pagecount=0;
        if (rowcount%pagesize==0){
            pagecount=rowcount/pagesize;
        }
        else {
            pagecount=rowcount/pagesize+1;
        }
        System.out.println("获取pagecount成功");
        return pagecount;
    }

    public ArrayList showSelectResult(String selectssql){  //根据sql语句分页查询所有学生的成绩信息
        List scoreal = new ArrayList();
        try {
            conn=new DBManager().getConnection();
            stamt=conn.createStatement();
            rs=stamt.executeQuery(selectssql);
            while (rs.next()){
                score_bean sb=new score_bean();
                sb.setStu_id(rs.getInt(1));
                sb.setStu_name(rs.getString(2));
                sb.setWeb_app(rs.getInt(3));
                sb.setJava(rs.getInt(4));
                sb.setOs(rs.getInt(5));
                scoreal.add(sb);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return (ArrayList) scoreal;
    }

    public ArrayList selectscore(int id){   //根据学号查询该学生的所有成绩信息，并以ArrayList形式返回
        List sec = new ArrayList();
        try {
            conn=new DBManager().getConnection();
            stamt=conn.createStatement();
            String sql="select * from stu_score where id="+id;
            rs=stamt.executeQuery(sql);
            while (rs.next()){
                score_bean sb=new score_bean();
                sb.setStu_id(rs.getInt(1));
                sb.setStu_name(rs.getString(2));
                sb.setWeb_app(rs.getInt(3));
                sb.setJava(rs.getInt(4));
                sb.setOs(rs.getInt(5));
                sec.add(sb);
            }
            rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return (ArrayList) sec;
    }


    public boolean AddScores(int stu_id, String stu_name,int web_app,int java,int os){  //新增一个新的学生成绩信息
        boolean flag=false;
        try {
            conn=new DBManager().getConnection();
            stamt=conn.createStatement();
            String sql="INSERT INTO stu_score(id,name,WebAppDevelop,JAVA,OperatingSystem)VALUES("+stu_id+","+"'"+stu_name+"'"+","+web_app+","+java+","+os+")";
            stamt.executeUpdate(sql);
            flag=true;
            System.out.println("添加信息成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public boolean DeleteScores(int id){    //根据获取的学号id值，删除该学生的成绩信息
        boolean flag=false;
        try {
            conn=new DBManager().getConnection();
            stamt=conn.createStatement();
            String sql="delete  from stu_score where id="+id;
            stamt.executeUpdate(sql);
            flag=true;
            System.out.println("成功删除学号为:"+id);


            }catch (Exception e){
            e.printStackTrace();
        }
        return  flag;
    }

    public  boolean UpdateScores(int id, String name , int webapp, int java, int os){   //根据获取的学号，更新该学号的学生成绩信息
        boolean flag=true;
        try {

                conn=new DBManager().getConnection();
                stamt=conn.createStatement();
                String sql="update stu_score set name="+"'"+name+"'"+","+"WebAppDevelop="+webapp+","+"JAVA="+java+","+"OperatingSystem="+os+" where id=" +id;
                stamt.executeUpdate(sql);
                flag=true;
                System.out.println("修改成功，学号为"+id+"的学生");
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }






}