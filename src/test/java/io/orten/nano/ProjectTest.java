package io.orten.nano;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProjectTest {

    private SessionFactory sessionFactory;
    private Session s;
    @Before
    public void before(){
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

   /* public void saveproject()

    {
        Project pro= new Project(5,"Amir", null,null ,678
                , 765, 99999, "Socity", null, "Yahya",false, true, null, "Stockholm1");
        s.save(pro);
    }*/

    @After
    public void after(){
        s.getTransaction().commit();
        s.close();
        sessionFactory.close();
    }
}