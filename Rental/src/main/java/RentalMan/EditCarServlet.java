package RentalMan;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editcar")
public class EditCarServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int carid = Integer.parseInt(request.getParameter("id"));

		EntityManager em = EMFProvider.getEntityManager();

		Car car = em.find(Car.class, carid);

		em.close();
		request.setAttribute("car", car);
		request.getRequestDispatcher("editcar.jsp").forward(request, response);
	}
}
