package com.alpha.config;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "/")
public class WebConfig implements WebMvcConfigurer{
	 
	 @Bean
	   public InternalResourceViewResolver resolver() {
		 System.out.println("InternalResourceViewResolver:::");
	      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	      resolver.setViewClass(JstlView.class);
	      resolver.setPrefix("/WEB-INF/views/");
	      resolver.setSuffix(".jsp");
	      return resolver;
	   }
	 
	   @Bean
	   public MessageSource messageSource() {
		   System.out.println("MessageSource:::");
	      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	      source.setBasename("messages");
	      return source;
	   }
	 
	   @Override
	   public Validator getValidator() {
		   System.out.println("Validator:::");
//	      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//	      validator.setValidationMessageSource(messageSource());
	      return null;
	   }
}
