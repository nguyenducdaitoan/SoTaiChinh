package vn.softech.hibernate;

/*
 * HibernateUtil.java
 *
 * Created on January 8, 2007, 2:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
import vn.softech.hibernate.exceptions.InfrastructureException;
import org.apache.log4j.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

/**
 *
 * Basic Hibernate helper class, handles SessionFactory, Session and Transaction.
 * <p>
 * Uses a static initializer for the initial SessionFactory creation
 * and holds Session and Transactions in thread local variables. All
 * exceptions are wrapped in an unchecked InfrastructureException.
 *
 * @author lehvuk22@gmail.com
 */
public class HibernateSessionFactory {
    private static Logger log = Logger.getLogger(HibernateSessionFactory.class);
    
    private static AnnotationConfiguration configuration;
    private static SessionFactory sessionFactory;
    private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
    private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();
        
    static 
    {
        try 
        {
            configuration = new AnnotationConfiguration();
            sessionFactory = configuration.configure().buildSessionFactory();
        } 
        catch (Throwable ex) 
        {
            log.error("Building SessionFactory failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /**
     * Returns the SessionFactory used for this static class.
     *
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    /**
     * @author lehvuk22@gmail.com
     * @since June 30, 2009
     * @param factory
     */
    public static void setSessionFactory(SessionFactory factory) {
    	HibernateSessionFactory.sessionFactory = factory;
    }

    
    /**
     * Returns the original Hibernate configuration.
     *
     * @return Configuration
     */
    public static Configuration getConfiguration() {
        return configuration;
    }
    
    /**
     * Rebuild the SessionFactory with the static Configuration.
     *
     */
    public static void rebuildSessionFactory() throws InfrastructureException 
    {
        synchronized(sessionFactory) {
            try {
                sessionFactory = getConfiguration().buildSessionFactory();
            } catch (Exception ex) {
                throw new InfrastructureException(ex);
            }
        }
    }
    
    /**
     * Rebuild the SessionFactory with the given Hibernate Configuration.
     *
     * @param cfg
     */
    public static void rebuildSessionFactory(AnnotationConfiguration cfg) throws InfrastructureException {
        synchronized(sessionFactory) {
            try {
                sessionFactory = cfg.buildSessionFactory();
                configuration = cfg;
            } catch (Exception ex) {
                throw new InfrastructureException(ex);
            }
        }
    }
    
    public static Session getCurrentSession() {
        return threadSession.get();
    }
    
    /**
     * Retrieves the current Session local to the thread.
     * <p/>
     * If no Session is open, opens a new Session for the running thread.
     *
     * @return Session
     */
    public static Session getSession() throws InfrastructureException {
    	log.debug("\n\n>>>>>>>>>>>>>>>\tHibernateSessionFactory.getSession()\t<<<<<<<<<<<<<<<\n");
        Session s = getCurrentSession();
        try {
            if (s == null || !s.isOpen()) {
                log.debug("Opening new Session for this thread.");
                s = getSessionFactory().openSession();
                threadSession.set(s);
            }
        } catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }
        return s;
    }
    
    /**
     * Closes the Session local to the thread.
     */
    public static void closeSession() throws InfrastructureException {
        try {
            Session s = getCurrentSession();
            threadSession.set(null);
            if (s != null && s.isOpen()) {
                log.debug("Closing Session of this thread.");
                s.close();
            }
        } catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }
    }
    
    /**
     * Start a new database transaction.
     */
    public static void beginTransaction() throws InfrastructureException {
        Transaction tx = threadTransaction.get();
        try {
            if (tx == null) {
                log.debug("Starting new database transaction in this thread.");
                tx = getSession().beginTransaction();
                threadTransaction.set(tx);
            }
        } catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }
    }
    
    /**
     * Commit the database transaction.
     */
    public static void commitTransaction() throws InfrastructureException {
        Transaction tx = threadTransaction.get();
        try {
            if ( tx != null && !tx.wasCommitted() && !tx.wasRolledBack() ) {
                log.debug("Committing database transaction of this thread.");
                tx.commit();
            }
            threadTransaction.set(null);
        } catch (HibernateException ex) {
            rollbackTransaction();
            throw new InfrastructureException(ex);
        }
    }
    
    /**
     * Commit the database transaction.
     */
    public static void rollbackTransaction() throws InfrastructureException {
        Transaction tx = threadTransaction.get();
        try {
            threadTransaction.set(null);
            if ( tx != null && !tx.wasCommitted() && !tx.wasRolledBack() ) {
                log.debug("Tyring to rollback database transaction of this thread.");
                tx.rollback();
            }
        } catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        } finally {
            closeSession();
        }
    }
    
    /**
     * Reconnects a Hibernate Session to the current Thread.
     *
     * @param session The Hibernate Session to be reconnected.
     */
/*
    public static void reconnect(Session session) throws InfrastructureException {
        try {
            session.reconnect();
            threadSession.set(session);
        } catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }
    }
*/    
    /**
     * Disconnect and return Session from current Thread.
     *
     * @return Session the disconnected Session
     */
    public static Session disconnectSession() throws InfrastructureException {
        
        Session session = getSession();
        try {
            threadSession.set(null);
            if (session.isConnected() && session.isOpen())
            {
                session.disconnect();
                log.info("Session is disconnect");
            }
        } catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }
        return session;
    }
    
    /**
     * Closes the current SessionFactory and releases all resources.
     * <p>
     * The only other method that can be called on HibernateUtil
     * after this one is rebuildSessionFactory(Configuration).
     */
    public static void shutdown() {
       
        // Close caches and connection pools
        getSessionFactory().close();

        // Clear static variables
        sessionFactory = null;
    }
    
}
