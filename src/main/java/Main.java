import models.Card;
import models.Passport;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(User.class).addAnnotatedClass(Passport.class).addAnnotatedClass(Card.class).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(new User("vasya", new Passport("87y8gdfs"), Arrays.asList(new Card(11214321432143214L), new Card(1324123412341234L))));
        session.save(new User("petya", new Passport("8yre8gh"), Arrays.asList(new Card(2214321432143214L), new Card(2324123412341234L))));
        session.save(new User("olya", new Passport("fdpnidh"), Arrays.asList(new Card(3214321432143214L), new Card(3324123412341234L))));
        session.save(new User("kolya", new Passport("asu745w736"), Arrays.asList(new Card(4214321432143214L), new Card(4324123412341234L))));


        session.getTransaction().commit();
        //todo wtf in sd jpa
//        List<Passport> passports = session.createQuery("select p from Passport p", Passport.class).getResultList();
//        passports.forEach(passport -> System.out.println(passport));
//        passports.forEach(passport -> System.out.println(passport.getUser()));

//        List<User> users = session.createQuery("select u from  User u", User.class).getResultList();
//        users.forEach(user -> System.out.println(user));
//        users.forEach(user -> System.out.println(user.getCards()));

//        List<Card> cards = session.createQuery("select c from Card c join fetch c.user u ", Card.class).getResultList();
//        cards.forEach(card -> System.out.println(card));
//        cards.forEach(card -> System.out.println(card.getUser()));

        session.createQuery("select c.user from Card c",User.class).getResultList().forEach(user -> System.out.println(user));

        session.close();
        sessionFactory.close();


    }
}
