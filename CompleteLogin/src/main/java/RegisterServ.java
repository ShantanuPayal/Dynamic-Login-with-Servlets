import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, username, and password of MySQL server
    private static final String Url= "jdbc:mysql://localhost:3306/jdbc";
    private static final String User= "root";
    private static final String Password = "shantanu1";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Extracting information from the request
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Connection conn = null;
     

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(Url, User,Password);

            // SQL query to insert data into the register table
        

            PreparedStatement pst= conn.prepareStatement("insert register (name, address, email, login, password) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, email);
            pst.setString(4, login);
            pst.setString(5, password);

            // Execute the insert statement
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<h2>Registration successful!</h2>");
              
            } else {
                out.println("<h2>Registration failed</h2>");
              
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
            
        
    }
}
