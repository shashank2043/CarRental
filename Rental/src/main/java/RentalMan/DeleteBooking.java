package RentalMan;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletebooking")
public class DeleteBooking extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookingId = Integer.parseInt(req.getParameter("id"));

		EntityManager em = EMFProvider.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Booking b = em.find(Booking.class, bookingId);
		if(b!=null) {
		Car c = em.find(Car.class, b.getCarid());
		c.setStatus("available");
		em.remove(b);
		em.merge(c);
		}
		et.commit();
		em.close();
		resp.sendRedirect("admin");
	}
}
