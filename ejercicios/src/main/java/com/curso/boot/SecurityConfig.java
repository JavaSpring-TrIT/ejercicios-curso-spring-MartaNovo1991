package com.curso.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .inMemoryAuthentication()
        .withUser("user1")
        .password("{noop}user1") //lo de {noop} se pone para no obligar a usar mecanismo de encriptación
        .roles("INVITADO")
        .and()
        .withUser("user2")
        .password("{noop}user2")
        .roles("OPERADOR")
        .and().withUser("user3")
        .password("{noop}user3")
        .roles("ADMIN")
        .and()
        .withUser("user4")
        .password("{noop}user4")
        .roles("OPERADOR", "ADMIN");


  }
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.POST,"/nuevoCurso").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE,"/borrarCurso/**").hasAnyRole("ADMIN","OPERADOR")
        .antMatchers(HttpMethod.PUT,"/actualizarCurso/**").hasAnyRole("ADMIN","OPERADOR")
        .antMatchers("/buscarCurso/**").authenticated()
        .antMatchers("/cursos").authenticated()
        .and()
        .httpBasic();

  }

}
