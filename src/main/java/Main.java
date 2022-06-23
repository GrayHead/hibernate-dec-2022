import models.Gendrer;
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
        Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Passport.class).addAnnotatedClass(User.class).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(new User("kokos", new Passport("qywerygafdua"), Gendrer.FEMALE, Arrays.asList("java","html")));
        session.save(new User("ananas", new Passport("oiyiuehg"), Gendrer.MALE , Arrays.asList("java","js")));
        session.save(new User("banan", new Passport("riyehdogfhi"), Gendrer.MALE, Arrays.asList("java","html")));
        session.save(new User("tomat", new Passport("987f8tgf0g"), Gendrer.FEMALE, Arrays.asList("java","mysql")));
        session.save(new User("potatos", new Passport("ogy8egy8e7g8"), Gendrer.FEMALE , Arrays.asList("java","mongo")));
        session.save(new User("mango", new Passport("rty8erg8g82r7f"), Gendrer.FEMALE , Arrays.asList("java")));


        session.getTransaction().commit();


//        List<User> users = session.createNativeQuery("select * from user_table", User.class).getResultList();
//        List<User> users =
//                session
//                        .createQuery("select u from User u where  u.id>:id and u.name=:name", User.class)
//                        .setParameter("id", 2)
//                        .setParameter("name","vasya")
//                        .getResultList();
//        System.out.println(users);

//        User user = session.find(User.class, 1);
//        System.out.println(user);
//        user.setName("utwqeuqwe");
//
//        session.beginTransaction();
////        session.update(user);
//
//        session.delete(user);
//        session.getTransaction().commit();


        //        List<Passport> resultList = session.createQuery("select u.passport from User u", Passport.class).getResultList();
//        System.out.println(resultList);

        List<User> users = session.createQuery("select u from User u", User.class).getResultList();
        System.out.println(users.get(0).getPassport());
        session.close();
        sessionFactory.close();


    }
}
