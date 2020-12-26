package tn.esprit.spring;

import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"tn.esprit.spring.controller,tn.esprit.spring.service"})
public class SpringBootExamBlancApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExamBlancApplication.class, args);
	}
	  public ServletRegistrationBean servletRegistrationBean() {
	        FacesServlet servlet = new FacesServlet();
	        return new ServletRegistrationBean(servlet, "*.jsf");
	    }
	    @Bean
	    public FilterRegistrationBean rewriteFilter() {
	        FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
	        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
	                DispatcherType.ASYNC, DispatcherType.ERROR));
	        rwFilter.addUrlPatterns("/*");
	        return rwFilter;
	    }

}
 