import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DecoOrderServlet")
public class DecoOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表单数据
        String choice = request.getParameter("choice");

        // 获取当前Session
        HttpSession session = request.getSession();
        String uid = (String) session.getAttribute("uid");

        // 检查uid是否存在
        if (uid == null) {
            // 如果uid不存在，重定向到登录页面
            response.sendRedirect("login.html");  // 假设有一个登录页面
            return;
        }

        // 数据库连接信息
        String jdbcURL = "jdbc:mysql://localhost:3306/bigmisu8";
        String dbUser = "root";
        String dbPassword = "root";

        // 查找或插入数据到数据库
        String selectSql = "SELECT * FROM log_cache WHERE uid = ?";//SQL：查询UID是否存在于数据库（即是否提交过信息）
        String insertSql = "INSERT INTO log_cache (uid, deco) VALUES (?, ?)";//SQL:插入信息到数据库（该UID未曾插入过任何数据时）
        String updateSql = "UPDATE log_cache SET deco = ? WHERE uid = ?";//SQL:更新信息（用于UID重复提交的信息覆盖）

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement selectStatement = connection.prepareStatement(selectSql);
             PreparedStatement insertStatement = connection.prepareStatement(insertSql);
             PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {

            // 查找uid对应的记录
            selectStatement.setString(1, uid);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                // 如果uid存在，更新deco值
                updateStatement.setString(1, choice);
                updateStatement.setString(2, uid);
                updateStatement.executeUpdate();
            } else {
                // 如果uid不存在，插入新的记录
                insertStatement.setString(1, uid);
                insertStatement.setString(2, choice);
                insertStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database access error");
        }

        // 重定向到一个确认页面
        response.sendRedirect("preview.html");
    }
}
