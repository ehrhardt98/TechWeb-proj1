package br.edu.Insper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CriaMural
 */
@WebServlet("/CriaMural")
public class CriaMural extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriaMural() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao;
		
		Integer id_usuario;
		id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
		try {
			dao = new DAO();

			Mural mural = new Mural();
			mural.setIdUsuario(id_usuario);
			mural.setNome("Novo Mural");

			dao.adicionaMural(mural);
			dao.close();

			request.setAttribute("id_usuario", id_usuario);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
			
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
