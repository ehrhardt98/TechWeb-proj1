package br.edu.Insper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao;
		try {
			dao = new DAO();

			Usuario usuario = new Usuario();
			String site;
			String user;
			String senha;
			
			site = "http://localhost:8080/TechWeb-proj1/inicio.jsp";
			user = request.getParameter("username-login");
			senha = request.getParameter("senha-login");
			
			
			for(Usuario u : dao.getListaUsuarios()) {
				if(u.getNome().equals(user) && u.getSenha().equals(senha)) {
					site = "http://localhost:8080/TechWeb-proj1/mural.jsp";
				}
			}
			
			dao.close();
			
			response.sendRedirect(site);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
