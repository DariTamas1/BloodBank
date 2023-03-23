package Repository;

import Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserRepository {

    public UserRepository(){
    }

    public static void save(User user, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public static User findByUsernameAndPassword(String username, String password, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        String hql = "from User where username = :username and password = :password";
        User user = session.createQuery(hql, User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .uniqueResult();
        return user;
    }

    public static int getUserId(User user, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        String hql = "select id from User where username = :username and password = :password";
        int id = session.createQuery(hql, Integer.class)
                .setParameter("username", user.getUsername())
                .setParameter("password", user.getPassword())
                .uniqueResult();
        return id;
    }

    public static void updateById(int id, String rol, String username, String password, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "update User set rol = :rol, username = :username, password = :password where id = :id";
        session.createQuery(hql)
                .setParameter("rol", rol)
                .setParameter("username", username)
                .setParameter("password", password)
                .setParameter("id", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteById(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "delete from User where id = :id";
        session.createQuery(hql)
                .setParameter("id", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
