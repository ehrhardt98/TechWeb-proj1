package br.edu.Insper;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.util.Base64;

/**
 * Servlet implementation class ViewBlob
 */
@WebServlet("/ViewBlob")
public class ViewBlob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBlob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("RECEIVED VIEW BLOB REQUEST PARAMS\n ");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		DAO dao;

		Integer id_mural = Integer.parseInt(request.getParameter("id_mural"));
		Integer id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
		
		
		try {
			dao = new DAO();
			
			Nota nota = new Nota();
			
			nota.setId(Integer.valueOf(request.getParameter("id_nota")));
			
			byte[] a = dao.viewBlob(nota);
			
			request.setAttribute("id_mural", id_mural);
			request.setAttribute("id_usuario", id_usuario);

			response.setContentType("image/gif");
			
			byte byteArray[] = a;
			byte[] base64encoded = Base64.encode(a);
			String base64 = new String(Base64.encode(byteArray));
//			OutputStream output = response.getOutputStream();
//			output.write(base64);
//			output.flush();
//			output.close();
			response.getWriter().println(base64);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mural.jsp");
			dispatcher.forward(request, response);
			
			dao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}
