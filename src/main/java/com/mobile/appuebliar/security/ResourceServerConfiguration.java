package com.mobile.appuebliar.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.filter.CorsFilter;

import com.mobile.appuebliar.util.RolEmum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/**").permitAll()
				.antMatchers(HttpMethod.PUT, "/sesion").permitAll()
				.antMatchers(HttpMethod.PUT, "/reserva").hasAnyRole(RolEmum.AVENTURERO.getRol())
				.antMatchers("/**").hasAnyRole(RolEmum.ADMIN.getRol())
				.anyRequest().denyAll().and()
				.cors().configurationSource(corsConfigurationSource());
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer configurer) {
		configurer.tokenServices(tokenServices());
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		return new JwtAccessTokenConverter() {
			{
				setSigningKey(JwtConfiguration.SIGNING_KEY);
				setVerifierKey(JwtConfiguration.VERIFIER_KEY);
			}
		};
	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		return new DefaultTokenServices() {
			{
				setTokenStore(tokenStore());
			}
		};
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		return new UrlBasedCorsConfigurationSource() {
			{
				registerCorsConfiguration("/", new CorsConfiguration() {
					{
						setAllowedOrigins(Collections.singletonList("*"));
						setAllowedMethods(Collections.singletonList("*"));
						setAllowCredentials(true);
						setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
					}
				});
			}
		};
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilterRegistrationBean() {
		return new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource())) {
			{
				setOrder(Ordered.HIGHEST_PRECEDENCE);
			}
		};
	}

}
