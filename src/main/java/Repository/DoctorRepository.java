package Repository;

import Model.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DoctorRepository {

    public static void save(Doctor doctor, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(doctor);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Doctor> findAll(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        String hql = "from Doctor";
        List<Doctor> doctors = session.createQuery(hql, Doctor.class).list();
        return doctors;
    }

    public static void deleteById(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "delete from Doctor where id = :id";
        session.createQuery(hql)
                .setParameter("id", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public static void updateById(int id, String name, String email, String address, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "update Doctor set name = :name, email = :email, address = :address where id = :id";
        session.createQuery(hql)
                .setParameter("name", name)
                .setParameter("email", email)
                .setParameter("address", address)
                .setParameter("id", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public static int getUserIdByDoctorId(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        String hql = "select id from User u INNER JOIN Doctor d ON u.id = d.userId where d.id = :id";
        int userId = session.createQuery(hql, Integer.class)
                .setParameter("id", id)
                .uniqueResult();
        return userId;
    }
}
