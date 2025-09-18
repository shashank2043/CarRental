package RentalMan;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatecar")
public class UpdateCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int carid = Integer.parseInt(request.getParameter("carid"));
        String carname = request.getParameter("carname");
        String carmodel = request.getParameter("carmodel");
        int carnumber = Integer.parseInt(request.getParameter("carnumber"));
        String ownername = request.getParameter("ownername");
        String status = request.getParameter("status");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("app");
        EntityManager em = emf.createEntityManager();

        Car car = em.find(Car.class, carid);

        if (car != null) {
            em.getTransaction().begin();
            car.setCarname(carname);
            car.setCarmodel(carmodel);
            car.setCarnumber(carnumber);
            car.setOwnername(ownername);
            car.setStatus(status);
            em.getTransaction().commit();
        }

        em.close();
        emf.close();

        response.sendRedirect("admin"); // reload admin page
    }
}

