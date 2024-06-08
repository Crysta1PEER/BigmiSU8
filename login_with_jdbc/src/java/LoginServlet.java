import Server_Connecter.Login;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

//基于本地缓存session的登录，信息来源为jdbc数据库“bigmusu8"。
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        String password = request.getParameter("password");
        
        // 获取当前会话的 HttpSession 对象
        HttpSession session = request.getSession();

        // 检查 Session 中是否包含登录信息
        String suid = (String) session.getAttribute("uid");

        if (suid != null) {
            response.getWriter().println("<script>alert('" + "检测到本地登录缓存，即将自动跳转" + "'); setTimeout(function(){ window.location.href='./welcome.jsp?uid='+uid'; }, 5000);</script>");
        } else {
        // 用户未登录
        // 执行未登录处理逻辑，如跳转到登录页面或返回未登录错误消息
        String login_result;
        response.setContentType("text/html;charset=utf-8");
        
        Login login = new Login();
        // 在这里进行数据库验证，使用 MyBatis 或其他数据库操作工具
        login_result = login.loginUser(uid,password);
        if(login_result.contains("成功")){
            session.setAttribute("uid", uid);
            response.getWriter().println("<script>alert('" + login_result + "'); setTimeout(function(){ window.location.href='./welcome.jsp; });</script>");
        }else{
            response.getWriter().println("<script>alert('" + login_result + "'); setTimeout(function(){ window.location.href='./login.jsp'; });</script>");
        }
        }
    }
}
