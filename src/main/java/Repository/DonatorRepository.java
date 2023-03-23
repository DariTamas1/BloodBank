package Repository;

import Model.Donator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DonatorRepository {

    public static void save(Donator donator, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(donator);
        session.getTransaction().commit();
        session.close();
    }
}
