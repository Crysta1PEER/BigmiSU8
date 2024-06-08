package Server_Connecter;

import java.sql.*;

public class Userinfo {

        //使用bigmisu8数据库。
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
      static final String DB_URL = "jdbc:mysql://localhost:3306/bigmisu8?useUnicode=true&characterEncoding=utf8";

    // 数据库的用户名和密码
    static final String USER = "root";
    static final String PASS = "root";

    public static String getUserInfo(String uid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 注册 JDBC 驱动程序
            Class.forName(JDBC_DRIVER);

            // 打开一个连接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 查询用户信息;在customer中查询nickname(昵称)与payment（是否订车），将其展示在页面上。查询条件为uid（用户标识码）
            String query = "SELECT nickname, payment FROM customer WHERE uid = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, uid);
            rs = pstmt.executeQuery();

            // 提取查询结果
            if (rs.next()) {
                String nickname = rs.getString("nickname");
                return nickname + "你好！";//展示用户信息，可修改。
            } else {
                return "未找到该用户信息";
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
        return "查询用户信息失败";
    }
}
