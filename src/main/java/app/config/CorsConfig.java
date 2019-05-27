package main.java.app.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class CorsConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	  public FilterRegistrationBean<CorsFilter> customCorsFilter() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setMaxAge(new Long(1800));
	    configuration.setAllowCredentials(true);
	    configuration.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
	    configuration.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));
	    configuration.setAllowedOrigins(Arrays.asList(CorsConfiguration.ALL));
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	source.registerCorsConfiguration("/**", configuration);

	FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
	bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	return bean;
	  }

	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.cors().and().csrf().disable();
	  }
}
