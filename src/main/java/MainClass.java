import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ProductEntity.class)
                //               .addAnnotatedClass(Author.class)
//                .addAnnotatedClass(Reader.class)
                .buildSessionFactory();
        // CRUD
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();

        ProductEntity product = session.get(ProductEntity.class, 1);
        product.setTitle("IceCream");
        session.save(product);
        session.getTransaction().commit();
        System.out.println(product);

    }
}
