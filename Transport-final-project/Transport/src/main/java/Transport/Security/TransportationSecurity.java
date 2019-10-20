package Transport.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class TransportationSecurity extends WebSecurityConfigurerAdapter {

    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("user")
                .password(encoder()
                        .encode("password"))
                .roles(USER_ROLE)
                .and()
                .withUser("admin")
                .password(encoder()
                        .encode("PASSWORD"))
                .roles(USER_ROLE, ADMIN_ROLE);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/edit").hasAnyRole(ADMIN_ROLE,USER_ROLE)
                .antMatchers(HttpMethod.GET ,"/edit/{id}").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET ,"/delete/{id}").hasRole(ADMIN_ROLE)
                .and()
                .csrf()
                .disable()
                .formLogin()
                .disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}

