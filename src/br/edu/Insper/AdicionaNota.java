package br.edu.Insper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdicionaNota
 */
@WebServlet("/AdicionaNota")
public class AdicionaNota extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdicionaNota() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao;
		try {
			dao = new DAO();

			Nota nota = new Nota();
			nota.setTipo("texto");
			nota.setConteudo(request.getParameter("create-note"));
			nota.setCor("#999999");
			nota.setTamanhoX(0);
			nota.setTamanhoY(0);
			nota.setIdMural(1);
			
			System.out.println(nota.getConteudo());
			PrintWriter out  = response.getWriter();
			out.println("<html>");
	    	out.println("<h1> Parabainz </h1>");
	    	out.println("<body>");
	    	out.println("</body>");
			out.println("</html>");

			dao.adicionaNota(nota);
			
			dao.close();
			
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
