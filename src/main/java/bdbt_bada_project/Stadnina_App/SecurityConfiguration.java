package bdbt_bada_project.Stadnina_App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import
        org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("$2a$10$5CyICm3/8lUjDwlc4cU.3uE6bSjxEcIBBoyPKr//gaATGqSTr9cJ.")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("$2a$10$uPWvrHkVhsGYFBbU1i1UMOzjGIo65b3W86cFdDrTCZIVUfFulfqEG")
                .roles("ADMIN");
        auth.jdbcAuthentication()
                .dataSource(jdbcTemplate.getDataSource())
                .usersByUsernameQuery("select Login, Haslo, 1 from Pracownicy where Login = ?")
                .authoritiesByUsernameQuery("select Login, 'ROLE_EMPLOYEE' from Pracownicy where Login = ?")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
        auth.jdbcAuthentication()
                .dataSource(jdbcTemplate.getDataSource())
                .usersByUsernameQuery("select Login, Haslo, 1 from Wlasciciele_koni where Login = ?")
                .authoritiesByUsernameQuery("select Login, 'ROLE_OWNER' from Wlasciciele_koni where Login = ?")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/new_breed").access("hasRole('ADMIN')")
                .antMatchers("/edit_breed").access("hasRole('ADMIN')")
                .antMatchers("/delete_breed").access("hasRole('ADMIN')")
                .antMatchers("/new_horse").access("hasRole('ADMIN')")
                .antMatchers("/owners").access("hasRole('ADMIN')")
                .antMatchers("/new_owner").access("hasRole('ADMIN')")
                .antMatchers("/edit_owner").access("hasRole('ADMIN')")
                .antMatchers("/delete_owner").access("hasRole('ADMIN')")
                .antMatchers("/edit_horse").access("hasRole('ADMIN')")
                .antMatchers("/delete_horse").access("hasRole('ADMIN')")
                .antMatchers("/edit_postcode").access("hasRole('ADMIN')")
                .antMatchers("/delete_postcode").access("hasRole('ADMIN')")
                .antMatchers("/new_postcode").access("hasRole('ADMIN')")
                .antMatchers("/postcodes").access("hasRole('ADMIN')")
                .antMatchers("/new_adress").access("hasRole('ADMIN')")
                .antMatchers("/edit_adress").access("hasRole('ADMIN')")
                .antMatchers("/delete_adress").access("hasRole('ADMIN')")
                .antMatchers("/adresses").access("hasRole('ADMIN')")
                .antMatchers("/employees").access("hasRole('ADMIN')")
                .antMatchers("/new_employee").access("hasRole('ADMIN')")
                .antMatchers("/edit_employee").access("hasRole('ADMIN')")
                .antMatchers("/employee_profile").access("hasRole('ROLE_EMPLOYEE')")
                .antMatchers("/owner_profile").access("hasRole('ROLE_OWNER')")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/")
                .logoutSuccessUrl("/")
                .permitAll();
    }
}