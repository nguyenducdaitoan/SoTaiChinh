/*
 * InfrastructureException.java
 *
 * Created on January 8, 2007, 2:29 PM
 *
 */

package vn.softech.hibernate.exceptions;

/**
 * This exception is used to mark (fatal) failures in infrastructure and system code.
 * @author lehvuk22@gmail.com
 */
public class InfrastructureException extends RuntimeException {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates a new instance of InfrastructureException */
    public InfrastructureException() {
    }
    
        
    public InfrastructureException(String message) {
        super(message);
    }
    
    public InfrastructureException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public InfrastructureException(Throwable cause) {
        super(cause);
    }    
}
