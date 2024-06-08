package Server_Connecter;

import java.sql.*;

public class BuildBridge {
    
    //连接数据库。使用数据库“bigmisu8”，使用表“customer”
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bigmisu8?useUnicode=true&characterEncoding=utf8";

    // 数据库的用户名和密码
    static final String USER = "root";
    static final String PASS = "root";

    public static String registerUser(String uid, String nickname, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // 注册 JDBC 驱动程序
            Class.forName(JDBC_DRIVER);

            // 打开一个连接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 在customer表查询是否已存在该 uid
            String query = "SELECT * FROM customer WHERE uid = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, uid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return "注册失败：uid已被注册";
            } else {
                // 如果 uid 未被注册，则插入新用户
                //插入内容：uid身份标识、昵称、密码
                String insertQuery = "INSERT INTO customer (uid, nickname, password) VALUES (?, ?, ?)";
                pstmt = conn.prepareStatement(insertQuery);
                pstmt.setString(1, uid);
                pstmt.setString(2, nickname);
                pstmt.setString(3, password);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    return "注册成功，欢迎您 " + nickname;
                }
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
