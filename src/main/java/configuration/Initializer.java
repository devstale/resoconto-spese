package configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import configuration.security.WebSecurityConfiguration;

/**
 * Configurazione Java per il DispatcherServlet, alternativa al web.xml.
 * Ogni classe che estende la classe {@link AbstractAnnotationConfigDispatcherServletInitializer} viene
 * automaticamente usata per configurare il DispatcherServlet e l'application context di Spring.
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * Mappiamo il dispatcher a "/" come path di default.
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	
	/**
	 * Metodo che restituisce le classi di configurazione che contengono i beans della nostra applicazione
	 * (fondamentalmente tutti i beans del middle-tier e data-tier).
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{ 
			DataConfiguration.class, 
			WebSecurityConfiguration.class
			};
	}
	
	/**
	 * Metodo che restituisce la classe che contiene i beans per configurare l'application context
	 * del DispatcherServlet (fondamentalmente la configurazione di Spring MVC)
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{ WebConfiguration.class};
	}

}
