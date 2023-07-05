import models.FinanceTransaction;
import models.Status;
import models.TransactionType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(FinanceTransaction.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(
                new FinanceTransaction(
                        TransactionType.DEBT,
                        Status.PENDING,
                        123.12,
                        true,
                        "lorem ipsum")
        );
        session.save(
                new FinanceTransaction(
                        TransactionType.CREDIT,
                        Status.COMPLETE,
                        654.654,
                        false,
                        "lorem ipsum 2")
        );

        session.save(
                new FinanceTransaction(
                        TransactionType.CREDIT,
                        Status.REJECT,
                        12312312,
                        true,
                        "lorem ipsum 3")
        );


        System.out.println("*************************");
        List<FinanceTransaction> transactions =
                session.createQuery("select t from FinanceTransaction t", FinanceTransaction.class).getResultList();
        System.out.println(transactions);
        System.out.println("*************************");
        FinanceTransaction transaction1 = session.find(FinanceTransaction.class, 1);
        System.out.println(transaction1);
        transaction1.setSum(100500);
        session.update(transaction1);


        session.getTransaction().commit();


        session.close();
        sessionFactory.close();


    }
}
