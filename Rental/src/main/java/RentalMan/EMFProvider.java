package RentalMan;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class EMFProvider {
	private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            Map<String, String> props = new HashMap<>();
            props.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            props.put("javax.persistence.jdbc.url", System.getenv("DB_URL"));
            props.put("javax.persistence.jdbc.user", System.getenv("DB_USER"));
            props.put("javax.persistence.jdbc.password", System.getenv("DB_PASSWORD"));
            props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            props.put("hibernate.hbm2ddl.auto", "update");
            props.put("hibernate.show_sql", "true");
            props.put("hibernate.format_sql", "true");

            emf = Persistence.createEntityManagerFactory("app", props);
        }
        return emf.createEntityManager();
    }

}
