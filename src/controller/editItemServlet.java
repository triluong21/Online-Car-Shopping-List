package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class editItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editItemServlet() {
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
		ListItemHelper dao = new ListItemHelper();
		String carmake = request.getParameter("carmake");
		String carmodel = request.getParameter("carmodel");
		String caryear = request.getParameter("caryear");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListItem itemToUpdate = dao.searchForCarById(tempId);
		itemToUpdate.setMake(carmake);
		itemToUpdate.setModel(carmodel);
		itemToUpdate.setYear(caryear);
		dao.updateCar(itemToUpdate);
		getServletContext().getRequestDispatcher("/viewAllItemServlet").forward(request, response);
	}

}
