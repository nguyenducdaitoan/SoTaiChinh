/********************************************************
 * @(#)HibernateSessionRequestFilter.java 1.0 2007/03/20
 *
 * Copyright 2007 Softech, Inc. All rights reserved.
 ********************************************************/

package vn.softech.hibernate;

import org.hibernate.SessionFactory;
import org.apache.log4j.*;
import javax.servlet.*;
import java.io.IOException;
import org.hibernate.StaleObjectStateException;

/**
 * Filter that manages a Hibernate Session for a request.
 * <p>
 * This filter should be used if your <tt>hibernate.current_session_context_class</tt>
 * configuration is set to <tt>thread</tt> and you are not using JTA or CMT.
 * <p>
 * 
 * @created 2008/06/22
 * @author lehvuk22@gmail.com
 * @version 1.0
 */
public class HibernateSessionManager implements Filter {
    
    private static Logger log = Logger.getLogger(HibernateSessionManager.class);
    private FilterConfig filterConfig = null;
    
    /**
     * Init Hibernate SessionFactory.
     * 
     * @param filterConfig 
     * @throws javax.servlet.ServletException 
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        SessionFactory sessFac = HibernateSessionFactory.getSessionFactory();
        log.info("Initializing filter...");
        log.info("Obtaining SessionFactory from HibernateSessionFactory");
    }
    
    /**
     * Manages a Hibernate Session for a request.
     * 
     * @param request 
     * @param response 
     * @param chain 
     * @throws java.io.IOException 
     * @throws javax.servlet.ServletException 
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                                        throws IOException, ServletException {
                
        try {
            request.setCharacterEncoding("UTF-8");
            // Call the next filter (continue request processing)
            chain.doFilter(request, response);
        } catch (StaleObjectStateException staleEx) {
            log.error("This interceptor does not implement optimistic concurrency control!");
            log.error("Your application will not work until you add compensation actions!");
            // Rollback, close everything, possibly compensate for any permanent changes
            // during the conversation, and finally restart business conversation. Maybe
            // give the user of the application a chance to merge some of his work with
            // fresh data... what you do here depends on your applications design.
            throw staleEx;
        } catch (Throwable ex) {
            // Rollback only
            ex.printStackTrace();
            try {
                if (HibernateSessionFactory.getSession().getTransaction().isActive()) {
                    log.info("Trying to rollback database transaction after exception");
                    HibernateSessionFactory.rollbackTransaction();
                }
            } catch (Throwable rbEx) {
                log.error("Could not rollback transaction after exception!", rbEx);
            }
            log.info(ex.toString());
            // Let others handle it... maybe another interceptor for exceptions?
            throw new ServletException(ex);
        } finally {
            // Closes The Session
        	log.debug("Closes The Session");
        	HibernateSessionFactory.closeSession();
        }
    }
    
    /**
     * Shutdown Hibernate
     */
    public void destroy() {
        this.filterConfig = null;
        log.info("Shutting down Hibernate");
        HibernateSessionFactory.shutdown();
    }   
}
