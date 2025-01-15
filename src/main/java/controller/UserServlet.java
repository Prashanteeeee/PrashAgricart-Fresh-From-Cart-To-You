package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.user.dao.UserDAO;
import com.user.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




@SuppressWarnings("unused")
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAO dao;
       
    
    public UserServlet() {
        super();
      
    }
    
    public void init()
    {
    	dao = new UserDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getServletPath();
		
		switch(action)
		{
		 case "/new":
	            showNewForm(request, response);
	            break;
	        case "/insert":
	            insertuser(request, response);
	            break;
	        case "/list":
	            listUser(request, response);
	            break;
	        case "/edit":
	            showEditForm(request, response);
	            break;
	        case "/update":
	            updateUser(request, response);
	            break;
	        case "/login":
	            login(request, response);
	            break;
	        case "/loginprocess":
	            try {
	                loginProcess(request, response);
	            } catch (SQLException | ServletException | IOException e) {
	                e.printStackTrace();
	            }
	            break;
	        case "/logout":
	            logout(request, response);
	            break;
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	
	public void loginProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDAO userDAO = new UserDAO(); 
		
		try(Connection connection = userDAO.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement("select * from users where email=? and password=?");
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("status", "active");
				httpSession.setAttribute("email", email);
				RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("status", "inactive");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
			
		} 
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession  httpSession=request.getSession();
		httpSession.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("id"));
	    User existingUser = dao.getUserById(id);
	    request.setAttribute("user", existingUser);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
	    dispatcher.forward(request, response);
	}

	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    int id = Integer.parseInt(request.getParameter("id"));
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String password = request.getParameter("password");

	    User user = new User();
	    dao.updateUser(user);
	    response.sendRedirect("user-list.jsp");
	}
	
	public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	public void insertuser(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String password = request.getParameter("password");
	    
	    User user = new User(null, name, email, phone, password, password, null, null); 
	    dao.addUser(user);
	    response.sendRedirect("list");
	}

	
	public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<User> users=dao.getAllUsers();
		request.setAttribute("users",users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
