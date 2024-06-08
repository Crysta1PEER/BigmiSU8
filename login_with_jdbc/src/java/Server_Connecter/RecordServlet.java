package Server_Connecter;

import static java.lang.System.out;
import java.sql.*;

//本java文档用于对用户进行的操作进行记录。每执行一次在线操作应在“log”表中留下用户操作日志。可不使用mybatis,仅使用JDBC即可。
public class RecordServlet {

        //使用数据库bigmisu8
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bigmusu8?useUnicode=true&characterEncoding=utf8";

    // 数据库的用户名和密码
    static final String USER = "root";
    static final String PASS = "root";

    public static String Record(String uid, String activity) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(JDBC_DRIVER);

            // 打开一个连接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 插入记录到 log 表
            String query = "INSERT INTO log (uid, activity) VALUES (?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, uid);
            pstmt.setString(2, activity);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                out.println("记录已成功插入到 log 表中！");
            } else {
                out.println("记录插入失败！");
            }

        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return "注册失败：发生未知错误";
    }
}
