package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class viewAllItemServlet
 */
@WebServlet("/viewAllItemServlet")
public class viewAllItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am here inviewAllItemServlet doGet");
		
		ListItemHelper dao = new ListItemHelper();
		
		request.setAttribute("allItems", dao.showAllCars());
		
		for(ListItem a: dao.showAllCars()) {
			System.out.println(a.getMake() + " " + a.getModel());
		}
		if(dao.showAllCars().isEmpty()){
			System.out.println("I am here inviewAllItemServlet doGet empty");
		request.setAttribute("allItems", " ");
		}
		getServletContext().getRequestDispatcher("/shopping-list.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am here inviewAllItemServlet doGet");
		doGet(request, response);
	}

}
