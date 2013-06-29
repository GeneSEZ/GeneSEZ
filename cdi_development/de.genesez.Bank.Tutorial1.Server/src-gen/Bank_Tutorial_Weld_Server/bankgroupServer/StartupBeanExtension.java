/**
 * 
 */
package Bank_Tutorial_Weld_Server.bankgroupServer;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessBean;

/**
 * Listens for the AfterDeploymentValidation Event to initialise start Up Beans 
 * earlier.
 * 
 * It is restricted to application scoped beans.
 * 
 */
public class StartupBeanExtension implements Extension {
	
	// a set of beans to initialise after server start
	private final Set<Bean<?>> startupBeans = new LinkedHashSet<Bean<?>>();

	/**
	 * Getting all startup beans noted with @Startup and @ApplicationScoped
	 * 
	 * @param <X>
	 * @param event
	 */
    <X> void processBean(@Observes ProcessBean<X> event)
    {
       if (event.getAnnotated().isAnnotationPresent(Startup.class)
    		   && event.getAnnotated().isAnnotationPresent(ApplicationScoped.class)
          )
       {
          startupBeans.add(event.getBean());
       }
    }
   
    /**
     * The event observer method to be called after deployment
     * 
     * @param event AfterDeploymentValidation
     * @param manager the bean managers
     */
    void afterDeploymentValidation(@Observes AfterDeploymentValidation event, BeanManager manager)
    {
       for (Bean<?> bean : startupBeans)
       {
          // the call to toString() is a cheat to force the bean to be initialized
          manager.getReference(bean, bean.getBeanClass(), manager.createCreationalContext(bean)).toString();
       }
    }
}
