package br.edu.Insper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		doPost(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		DAO dao;
		try {
			dao = new DAO();

			Usuario usuario = new Usuario();
			String site;
			String user;
			String senha;
			
			site = "/inicio.jsp";
			user = request.getParameter("username-login");
			senha = request.getParameter("senha-login");
			
			
			for(Usuario u : dao.getListaUsuarios()) {
				if(u.getNome().equals(user) && u.getSenha().equals(senha)) {
					site = "/home.jsp";
					usuario.setId(u.getId());
					usuario.setEmail(u.getEmail());
					usuario.setNome(u.getNome());
					usuario.setSenha(u.getSenha());
				}
			}
			
			dao.close();
			request.setAttribute("id_usuario", (usuario.getId()));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(site);
			dispatcher.forward(request, response);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
