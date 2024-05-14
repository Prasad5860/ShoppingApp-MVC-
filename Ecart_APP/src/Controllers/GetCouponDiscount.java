package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BLL.calculate;
import DAO.DataOject;
import DAO.conatractOb;

/**
 * Servlet implementation class GetCouponDiscount
 */
@WebServlet("/GetCouponDiscount")
public class GetCouponDiscount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCouponDiscount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String code = request.getParameter("couponCode");
		Double price = Double.parseDouble(request.getParameter("price"));
		conatractOb cb = null;
		DataOject d = new DataOject();
		cb = d.getobject();
		System.out.println("cupon code" + code);
		int dis = cb.getCouponDiscount(code);
		double discountPrice = calculate.GetDiscount(price, dis);
		HttpSession session = request.getSession();
		System.out.println("Discounted Price " + discountPrice);
		session.setAttribute("DiscountedPrice", discountPrice);
	}

}
