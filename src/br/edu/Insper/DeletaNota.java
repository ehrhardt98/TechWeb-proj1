package br.edu.Insper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletaNota
 */
@WebServlet("/DeletaNota")
public class DeletaNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletaNota() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		DAO dao;
		Integer idMural = Integer.parseInt(request.getParameter("id_mural"));
		Integer idUsuario = Integer.parseInt(request.getParameter("id_usuario"));
		
		dao = new DAO();
				
		String idstring = request.getParameter("id_nota");
		Integer id = Integer.parseInt(idstring);
		
		dao.removeNota(id);
		
		dao.close();
		
		request.setAttribute("id_mural", idMural);
		request.setAttribute("id_usuario", idUsuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mural.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
