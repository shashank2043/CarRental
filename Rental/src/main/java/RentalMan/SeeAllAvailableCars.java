package RentalMan;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/seeallavailablecars")
public class SeeAllAvailableCars extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManager em = EMFProvider.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		List<Car> cars = em.createQuery("Select c From Car c where c.status='available'",Car.class).getResultList();
		Collections.sort(cars,Comparator.comparingInt(Car::getCarid));
		req.setAttribute("cars", cars);
		RequestDispatcher rd = req.getRequestDispatcher("displaycars.jsp");
		rd.forward(req, resp);
	}
}
