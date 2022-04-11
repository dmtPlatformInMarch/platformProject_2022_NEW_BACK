package com.example.demo.config.security;

import com.example.demo.config.security.filter.ApiLoginProcessingFilter;
import com.example.demo.config.security.handler.ApiAuthenticationFailureHandler;
import com.example.demo.config.security.handler.ApiAuthenticationSuccessHandler;
import com.example.demo.config.security.provider.ApiAuthenticationProvider;
import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.repository.AccountRepository;
import com.example.demo.module.account.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final PasswordEncoder passwordEncoder;
	private final AccountRepository accountRepository;
	private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


	//security 적용 안 해도 되는 부분
	@Override
	public void configure(WebSecurity web) throws Exception {

		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);

		web.ignoring().antMatchers("/resources/**").antMatchers("/h2-console/**")
				.antMatchers("/css/**", "/js/**", "/img/**")
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}


	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
				.antMatchers("**").permitAll()
				//.antMatchers("/register", "/login", "/logout").permitAll()
			//	.antMatchers("/series/new", "project/new").hasAnyRole("ADMIN", "MANAGER")
				.anyRequest().authenticated()
				.and()
				.cors().configurationSource(corsConfigurationSource()).and()
				.addFilterBefore(ajaxLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class);

		http.headers().frameOptions().disable()
				.addHeaderWriter(new StaticHeadersWriter("X-FRAME-OPTIONS", "ALLOW-FROM " + "/translator/testExcelView/**")).and();
		http.formLogin()
				.loginPage("/login")
				// .successHandler(new RedirectHandler())
				.failureUrl("/login?error")
				.permitAll();

		http.logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true)
				.and().csrf().disable().httpBasic();


		http.headers(headers -> headers .cacheControl(cache -> cache.disable()) );
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.addAllowedOrigin("*");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		//configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	private final ApiAuthenticationProvider apiAuthenticationProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(apiAuthenticationProvider);
	}


	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	private final ApiAuthenticationSuccessHandler apiAuthenticationSuccessHandler;
	private final ApiAuthenticationFailureHandler apiAuthenticationFailureHandler;

	@Bean
	public ApiLoginProcessingFilter ajaxLoginProcessingFilter() throws Exception {
		ApiLoginProcessingFilter apiLoginProcessingFilter = new ApiLoginProcessingFilter();
		apiLoginProcessingFilter.setAuthenticationManager(authenticationManagerBean());

		apiLoginProcessingFilter.setAuthenticationSuccessHandler(apiAuthenticationSuccessHandler);
		apiLoginProcessingFilter.setAuthenticationFailureHandler(apiAuthenticationFailureHandler);
		return apiLoginProcessingFilter;

	}

}