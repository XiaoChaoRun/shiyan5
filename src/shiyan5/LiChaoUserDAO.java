package shiyan5;
/*
 Create by 2022 10.16
 @author  李超
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LiChaoUserDAO {
    private Connection conn;
    private Statement stmt = null;
    private ResultSet rs;

    public boolean RegistorUser(String username, String password) {  //根据传入的注册的用户名和密码，利用insert插入语句插入到数据库中
        boolean flag=false;
        conn = (new DBManager().getConnection());
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO admin_user (username,password)VALUES(" + "'" + username + "'" + "," + "'" + password + "'" + ")";
            stmt.executeUpdate(sql);
            flag=true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;

    }

    public boolean LoginUser(String username, String password) { //根据传入的用户名和密码在数据库中查询，如果结果集不为空证明输入正确
        boolean flag=false;
        conn = (new DBManager().getConnection());
        try {
            stmt = conn.createStatement();
            String sql = "select * from admin_user where `username`=" + "'" + username + "'" + " and `password`=" + "'" + password + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.println("该用户存在");
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}