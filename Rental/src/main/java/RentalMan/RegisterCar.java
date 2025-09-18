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

@WebServlet("/registercar")
public class RegisterCar extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carid = Integer.parseInt(req.getParameter("carid"));
		System.out.println(carid);
		String carname = req.getParameter("carname");
		System.out.println(carname);
		String carmodel = req.getParameter("carmodel");
		System.out.println(carmodel);
		int carnumber = Integer.parseInt(req.getParameter("carnumber"));
		System.out.println(carnumber);
		String ownername = req.getParameter("ownername");
		System.out.println(ownername);

		Car car = new Car(carid, carname, carmodel, carnumber, ownername);
		System.out.println(car);

		EntityManager em = EMFProvider.getEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(car);
		et.commit();
		em.close();
		RequestDispatcher rd = req.getRequestDispatcher("carregistered.html");
		rd.forward(req, resp);
	}
}
