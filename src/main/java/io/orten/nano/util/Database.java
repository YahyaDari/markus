package io.orten.nano.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Database {
        private static SessionFactory sessionFactory;
        private static void init(){
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
                    .build();
            MetadataSources mds = new MetadataSources(registry);
            Metadata md = mds.buildMetadata();
            sessionFactory = md.buildSessionFactory();
            //  Make sure that the service registry is destroyed on shutdown by adding a shutdown hook to the runtime
            Runtime.getRuntime().addShutdownHook(new Thread(() ->
            {
                StandardServiceRegistryBuilder.destroy(registry);
            }));
        }

        /**
         * saving an organization object to the database
        */
        public static void saveObject(Object o){
            if(sessionFactory == null)
                init();
            try(Session s = sessionFactory.openSession()){
                s.beginTransaction();
                s.save(o);
                s.getTransaction().commit();
            }
        }

        /**
         * updating an organization object
        */

        public static void updateOrganization(Object o){
            if(sessionFactory == null)
                init();
            try(Session s = sessionFactory.openSession()){
                s.beginTransaction();
                s.update(o);
                s.getTransaction().commit();
            }
        }

        /**
        * TODO: This need to be refactor
        */

        public static Session getSession() throws Exception {
            if(sessionFactory == null) {
                init();
            }
            Session session = sessionFactory.openSession();
            return session;
        }
 }