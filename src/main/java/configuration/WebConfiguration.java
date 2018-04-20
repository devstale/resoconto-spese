package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Classe di configurazione per Spring MVC.
 */
@Configuration
@EnableWebMvc
@ComponentScan("it.devstale.resoconto.spese")
public class WebConfiguration implements WebMvcConfigurer {
	
	/**
	 * Configurazione del ViewResolver per le JSP.
	 */
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		
		//in questo modo il Locale ed il message source viene passato direttamente
		//da Spring ai tag JSTL
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		
		return resolver;
	}
	
	/**
	 * Configuriamo la gestione dei contenuti statici (CSS, immagini).
	 * Settando il flag a true diciamo al DispatcherServlet di rigirare le richieste per
	 * le risorse statiche al servlet di default piuttosto che gestirli direttamente.
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}

}