package br.edu.Insper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlteraNota
 */
@WebServlet("/AlteraNota")
public class AlteraNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlteraNota() {
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
		try {
			
			dao = new DAO();
			
			Nota nota = new Nota();
			
			nota.setId(Integer.valueOf(request.getParameter("id_nota")));
			nota.setTipo(request.getParameter("tipo_nota"));
			nota.setConteudo(request.getParameter("edit_nota"));
			
			dao.alteraNota(nota);
			dao.close();
			
			request.setAttribute("id_mural", id_mural);
			request.setAttribute("id_usuario", id_usuario);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mural.jsp");
			dispatcher.forward(request, response);

			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
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
