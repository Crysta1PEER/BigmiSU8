import Server_Connecter.BuildBridge;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//此处未使用session,直接将数据插入至JDBC服务器”bigmisu8“
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        String checkPassword = request.getParameter("check_password");
        
        String result;
        response.setContentType("text/html;charset=utf-8");
        
        
        if (password.equals(checkPassword)) {
            BuildBridge register = new BuildBridge();
            result = register.registerUser(uid,nickname,password);
        } else {
            result = "注册失败：两次密码输入不一致";
        }
        
        if(result.contains("成功")){   
            response.getWriter().println("<script>alert('" + result + "'); setTimeout(function(){ window.location.href='./login.jsp'; },);</script>");
        }else{
            response.getWriter().println("<script>alert('" + result + "'); setTimeout(function(){ window.location.href='./register.jsp'; });</script>");
        }
    }
}
