

# Dynamic Login Web Application with Servlets

This repository contains a simple dynamic web application showcasing user login functionalities using Java servlets.

## Features

- **User Registration:** New users can register by providing their name, address, email, login, and password.
- **User Login:** Existing users can log in using their credentials.
- **Admin Panel:** Allows viewing all registered users.

## Technologies Used

- Java Servlets
- HTML
- CSS
- MySQL (for database)

## Database Configuration

1. **Database:** The application uses a MySQL database to store user information.
2. **Connection Settings:** Ensure the following connection settings in your servlet code (`LoginServ`, `RegisterServ`, `ViewServ`, etc.) match your MySQL configuration:
   - JDBC URL: `jdbc:mysql://localhost:3306/your_database_name`
   - Username: `your_username`
   - Password: `your_password`

## Setup Instructions

1. Clone the repository to your local machine.
2. Set up and configure a MySQL database.
3. Deploy the application on a server that supports Java servlets (e.g., Apache Tomcat).
4. Update the database connection settings in the servlets to match your MySQL configuration.
5. Access different functionalities through provided HTML pages (`register.html`, `login.html`, `Admin.html`).

## Database Interaction

- The application demonstrates how Java servlets interact with a MySQL database for user registration, login, and retrieval.
- Explore the servlet code (`LoginServ`, `RegisterServ`, `ViewServ`) to understand database connection, SQL queries, and result handling.

## Usage

- Run the application on a servlet-compatible server and interact with the HTML pages to experience the login functionalities.
- Use the provided HTML pages as interfaces to register new users, log in, or view registered users.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request for any improvements or additional features.


