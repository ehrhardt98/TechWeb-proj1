package br.edu.Insper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CriaUsuario
 */
@WebServlet("/CriaUsuario")
public class CriaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriaUsuario() {
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
			
			System.out.println(request.getParameter("username-create"));
			
			usuario.setNome(request.getParameter("username-create"));
			usuario.setSenha(request.getParameter("senha-create"));
			usuario.setEmail(request.getParameter("email-create"));
			
			dao.adicionaUsuario(usuario);

			dao.close();
			
			response.sendRedirect("http://localhost:8080/TechWeb-proj1/inicio.jsp");
			
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
