package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.DataOject;
import DAO.conatractOb;
import Modal.Product;

/**
 * Servlet implementation class CateWise
 */
@WebServlet("/CateWise")
public class CateWise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CateWise() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		List<Product> lp = null;
		String cat = request.getParameter("id");

		conatractOb cb = null;
		DataOject d = new DataOject();
		cb = d.getobject();
		lp = cb.getprd(cat);
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(lp));

	}

}
