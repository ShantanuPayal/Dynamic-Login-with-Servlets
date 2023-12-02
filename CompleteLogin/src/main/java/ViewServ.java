import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewServ")
public class ViewServ extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String Url= "jdbc:mysql://localhost:3306/jdbc";
    private static final String User= "root";
    private static final String Password = "shantanu1";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection conn = null;
 

        try {
     
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(Url,User,Password);

     
            PreparedStatement pst = conn.prepareStatement("select * from register");

      
            ResultSet rs = pst.executeQuery();

       
            out.println("<html><head><title>All Users</title></head><body>");
            out.println("<h1>All Registered Users</h1>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Address</th><th>Email</th><th>Login</th><th>Password</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("address") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("login") + "</td>");
                out.println("<td>" + rs.getString("password") + "</td>");
                out.println("</tr>");
            }

            out.println("</table></body></html>");

        } catch (Exception e) {
            e.printStackTrace();
        
        }
    }
}
