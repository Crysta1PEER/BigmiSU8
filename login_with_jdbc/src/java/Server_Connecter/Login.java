package Server_Connecter;

import java.sql.*;

public class Login {

    //使用数据库“bigmisu8”
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
     static final String DB_URL = "jdbc:mysql://localhost:3306/bigmisu8?useUnicode=true&characterEncoding=utf8";

    // 数据库的用户名和密码
    static final String USER = "root";
    static final String PASS = "root";

    public static String loginUser(String uid, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 注册 JDBC 驱动程序
            Class.forName(JDBC_DRIVER);

            // 打开一个连接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 查询customer表中是否已存在该 uid
            String query = "SELECT * FROM customer WHERE uid = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, uid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // 如果存在该 uid，检查密码是否正确
                String storedPassword = rs.getString("password");//备注：若要将该项目转化为使用mybatis，建议在此处使用session缓存以符合课程内容。同时注意添加登出模块。
                if (password.equals(storedPassword)) {
                    return "登录成功";
                } else {
                    return "登录失败：密码不正确";
                }
            } else {
                // 如果不存在该 uid，则返回用户名不存在
                return "登录失败：用户名不存在";
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
        return "登录失败：发生未知错误";
    }
}
