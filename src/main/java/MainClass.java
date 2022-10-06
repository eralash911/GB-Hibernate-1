import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ProductEntity.class)
                .buildSessionFactory();
        // CRUD
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();

        try {
            //CREATE
            session = factory.getCurrentSession();
            ProductEntity product1= new ProductEntity();

            product1.setTitle("Java Spring 1");
            session.beginTransaction();
            session.save(product1);
            session.getTransaction().commit();

            //READ
//        ProductEntity product = session.get(ProductEntity.class, 5);
//        product.setTitle("IceCream");
//        session.save(product);
//        session.getTransaction().commit();
//        System.out.println(product);

            //  UPDATE
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            ProductEntity product = session.get(ProductEntity.class, 2);
//            product.setTitle("Java 1 Advanced");
//            session.getTransaction().commit();
//            System.out.println(product);

            //DELETE

//            ProductEntity product = session.get(ProductEntity.class, 2);
//            session.delete(product);
//            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }
}
