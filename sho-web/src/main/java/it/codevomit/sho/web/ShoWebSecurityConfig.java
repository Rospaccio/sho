package it.codevomit.sho.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author merka
 */
@Configuration
public class ShoWebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception
    {
        authBuilder.inMemoryAuthentication()
                .withUser("shoadmin")
                .password("shoadmin")
                .roles("ADMIN");
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception
//    {
//        web.ignoring()
//                .antMatchers("/sho/**")
//                .antMatchers("/resources/**")
//                .antMatchers("/static/**");
//    }
    
    @Override
    @Order(Ordered.LOWEST_PRECEDENCE)
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/sho/web")
                .hasRole("ADMIN")
                .antMatchers("/sho/monaco-editor/**").permitAll()
                .and().formLogin();
    }

}
