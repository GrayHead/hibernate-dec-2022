import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(User.class).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

//        session.beginTransaction();
//
//        session.save(new User("kokos"));
//        session.save(new User("ananas"));
//        session.save(new User("banan"));
//        session.save(new User("tomat"));
//        session.save(new User("potatos"));
//        session.save(new User("mango"));
//
//
//        session.getTransaction().commit();


//        List<User> users = session.createNativeQuery("select * from user_table", User.class).getResultList();
//        List<User> users =
//                session
//                        .createQuery("select u from User u where  u.id>:id and u.name=:name", User.class)
//                        .setParameter("id", 2)
//                        .setParameter("name","vasya")
//                        .getResultList();
//        System.out.println(users);

        User user = session.find(User.class, 1);
        System.out.println(user);
        user.setName("utwqeuqwe");

        session.beginTransaction();
//        session.update(user);

        session.delete(user);
        session.getTransaction().commit();


        session.close();
        sessionFactory.close();


    }
}
