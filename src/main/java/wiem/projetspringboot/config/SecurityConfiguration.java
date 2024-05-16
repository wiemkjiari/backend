package wiem.projetspringboot.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import lombok.RequiredArgsConstructor;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {
 
	
	private final JwtAuthenticationFilter jwtAuthFilter ;
	private final AuthenticationProvider authenticationProvider ;
	
	
	@SuppressWarnings("removal")
	@Bean 
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			http
			  .cors()
              .and()
			  .csrf().disable()  
			  .authorizeHttpRequests()
			  .requestMatchers("api/auth/**" ).permitAll()  
			  .anyRequest().authenticated()  
			  .and()     
			  .authenticationProvider(authenticationProvider)
			  .addFilterBefore(jwtAuthFilter , UsernamePasswordAuthenticationFilter.class);
			//renvoie la configuration complète avec return 
		return http.build();  
		
	
	}
}
