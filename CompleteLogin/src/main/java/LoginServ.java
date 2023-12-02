import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String Url= "jdbc:mysql://localhost:3306/jdbc";
    private static final String User= "root";
    private static final String Password = "shantanu1";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(Url, User, Password);

            PreparedStatement pst = conn.prepareStatement("SELECT * FROM register WHERE login = ? AND password = ?");
            pst.setString(1, login);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                response.sendRedirect("success.html");
            } else {
                response.sendRedirect("fail.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
