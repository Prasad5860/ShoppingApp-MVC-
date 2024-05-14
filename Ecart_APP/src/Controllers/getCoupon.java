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
import Modal.Coupon;

/**
 * Servlet implementation class getCoupon
 */
@WebServlet("/getCoupon")
public class getCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

		Double price = Double.parseDouble(request.getParameter("price"));

		System.out.println("Price of order " + price);

		conatractOb cb = null;
		DataOject d = new DataOject();
		cb = d.getobject();

		List<Coupon> lCoupons = cb.getCoupons(price);
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(lCoupons));

	}

}
