import models.Gender;
import models.Passport;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Passport.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user1 = new User("vasya",
                "vasya@asd.com",
                Arrays.asList("java", "js"),
                Gender.MALE,
                new Passport("831t57wtf8g"));

        session.save(user1); // id-1

        User user2 = new User("petya",
                "petya@asd.com",
                Arrays.asList("java", "js"),
                Gender.MALE,
                new Passport("yasfdytfdy"));
        session.save(user2);

        session.getTransaction().commit();

        session.createQuery("select u from  User u", User.class).getResultList().forEach(System.out::println);


        session.getTransaction().begin();
        session.delete(user1);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();


    }
}
