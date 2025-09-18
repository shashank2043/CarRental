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

@WebServlet("/admin")
public class AdminManagement extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("app");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		List<Booking> bookings = em.createQuery("Select b from Booking b").getResultList();
		List<Car> cars = em.createQuery("Select c From Car c").getResultList();
		req.setAttribute("cars", cars);
		req.setAttribute("bookings", bookings);
		Collections.sort(cars,Comparator.comparingInt(Car::getCarid));
		RequestDispatcher rd = req.getRequestDispatcher("adminpage.jsp");
		rd.forward(req, resp);
	}
}
