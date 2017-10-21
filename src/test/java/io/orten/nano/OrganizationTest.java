package io.orten.nano;

import io.orten.nano.model.Organization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrganizationTest {
    private SessionFactory sessionFactory;
    private Session s;
    @Before
    public void before() {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
                    .build();
            MetadataSources mds = new MetadataSources(registry);
            Metadata md = mds.buildMetadata();
            sessionFactory= md.buildSessionFactory();
            //Make sure that the service registry is destroyed on shutdown by adding a shutdown hook to the runtime
            s = sessionFactory.openSession();
            s.beginTransaction();
            Runtime.getRuntime().addShutdownHook(new Thread(() ->
            {
                StandardServiceRegistryBuilder.destroy(registry);
            }));
    }

    @Test
    public void saveorganaization()
    {
        Organization org= new Organization("67","microsoft", "NY", "nwerme","0989769865"
                , "mdf@gmail.com", "newpassword45", "brooklyn",
                "154678", "very successful organisation");
        s.save(org);
    }

    @After
    public void after(){
        s.getTransaction().commit();
        s.close();
        sessionFactory.close();
    }
}