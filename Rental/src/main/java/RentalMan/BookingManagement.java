package RentalMan;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookcar")
public class BookingManagement extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManager em = EMFProvider.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Booking b = new Booking(req.getParameter("cname"), req.getParameter("sdate"), req.getParameter("ldate"), Integer.parseInt(req.getParameter("carid")));
		
		
		et.begin();
		em.persist(b);
		Car c = em.find(Car.class,Integer.parseInt(req.getParameter("carid")));
		c.setStatus("booked");
		em.merge(c);
		et.commit();
		em.close();
		RequestDispatcher rd = req.getRequestDispatcher("Booked.html");
		rd.forward(req, resp);
	}
}
