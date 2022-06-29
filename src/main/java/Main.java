import models.Car;
import models.DriveLicense;
import models.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Owner.class).addAnnotatedClass(Car.class).addAnnotatedClass(DriveLicense.class).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Owner owner = new Owner("vasya", Arrays.asList(new Car("asd"), new Car("qwe")), new DriveLicense("fqfq7wt6erq7weg"));
        session.save(owner);


        session.getTransaction().commit();

        session.close();
        sessionFactory.close();


    }
}
