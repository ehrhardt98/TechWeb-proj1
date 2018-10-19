package br.edu.Insper;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadBlob
 */
@MultipartConfig
@WebServlet("/CriaBlob")
public class CriaBlob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriaBlob() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		DAO dao;
		
		Integer id_mural = Integer.parseInt(request.getParameter("id_mural"));
		Integer id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
		
		PrintWriter out = response.getWriter();
		Part part = request.getPart("blob");
		
		if (part != null) {
			try {
				dao = new DAO();
				
				Nota nota = new Nota();
				InputStream input = part.getInputStream();
				
				nota.setId(Integer.valueOf(request.getParameter("id_nota")));
				nota.setBlob(input);
				
				nota.setIdMural(id_mural);
				
				dao.adicionaBlob(nota);
				
				dao.close();
				
				request.setAttribute("id_mural", id_mural);
				request.setAttribute("id_usuario", id_usuario);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/mural.jsp");
				dispatcher.forward(request, response);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
