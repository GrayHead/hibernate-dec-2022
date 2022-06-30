import models.Card;
import models.Passport;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(User.class).addAnnotatedClass(Passport.class).addAnnotatedClass(Card.class).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

//        session.save(new User("vasya", new Passport("87y8gdfs"), Arrays.asList(new Card(11214321432143214L), new Card(1324123412341234L))));
//        session.save(new User("petya", new Passport("8yre8gh"), Arrays.asList(new Card(2214321432143214L), new Card(2324123412341234L))));
//        session.save(new User("olya", new Passport("fdpnidh"), Arrays.asList(new Card(3214321432143214L), new Card(3324123412341234L))));
//        session.save(new User("kolya", new Passport("asu745w736"), Arrays.asList(new Card(4214321432143214L), new Card(4324123412341234L))));

        User user = new User("vasya");
        System.out.println(user);
        Card card1 = new Card(12312312313L, user);
        System.out.println(user);
        Card card2 = new Card(3245345, user);
        System.out.println(user);
        session.save(card1);
        session.save(card2);
        System.out.println(user);


        session.getTransaction().commit();

        session.close();
        sessionFactory.close();


    }
}
