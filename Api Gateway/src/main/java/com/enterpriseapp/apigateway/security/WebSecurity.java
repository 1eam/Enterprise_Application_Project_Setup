package com.enterpriseapp.apigateway.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final Environment environment;

    public WebSecurity(Environment environment) {
        this.environment = environment;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //disables csrf and allows for h2 db to be seen
        http.csrf().disable();
        http.headers().frameOptions().disable();

        //allows http requests without authorization to the following paths: (values of env.getProperty method)
        http.authorizeRequests()
                .antMatchers(environment.getProperty("api.zuul.actuator.url.path")).permitAll()
                .antMatchers(environment.getProperty("api.h2Console.url.path")).permitAll()
//                .antMatchers(HttpMethod.GET, environment.getProperty("api.status.url.path")).permitAll()
                .antMatchers(HttpMethod.POST, environment.getProperty("api.registration.url.path")).permitAll()
                .antMatchers(HttpMethod.POST, environment.getProperty("api.login.url.path")).permitAll()
                //finally any other request should be authenticated
                .anyRequest().authenticated()
        .and()
        .addFilter(new AuthorizationFilter(authenticationManager(), environment));

        //prohibits microservice (Spring) from creating http session, makes this API stateless to avoid cashing
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }
}
