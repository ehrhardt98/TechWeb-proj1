package br.edu.Insper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdicionaNota
 */
@WebServlet("/CriaNota")

public class CriaNota extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CriaNota() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao;
		Integer id_mural = Integer.parseInt(request.getParameter("id_mural"));
		Integer id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
		
		PrintWriter out = response.getWriter();
		try {
			dao = new DAO();

			Nota nota = new Nota();
			nota.setTipo("texto");
			nota.setConteudo(request.getParameter("create_note"));
			
			nota.setIdMural(id_mural);

			dao.adicionaNota(nota);

			dao.close();

			request.setAttribute("id_mural", id_mural);
			request.setAttribute("id_usuario", id_usuario);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mural.jsp");
			dispatcher.forward(request, response);
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
