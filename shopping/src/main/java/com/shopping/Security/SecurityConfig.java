package com.shopping.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class SecurityConfig {
	
	   @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .requestMatchers(
                		"file:/home/test/Downloads/imgupload/**",
                    "/user/save",    
                    "/user/getall", 
                    "/user/getById/**", 
                    "/user/delete/**",   
                    "/user/update/**" ,
                    "/user/login",
                    "/products",
                    "/products/getall",
                    "/products/getById/**",
                    "/products/delete/**",
                    "products/update/**",
                    "products/image",
                    "category/save",
                    "/**"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
            .httpBasic()
                .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }
   
    }
    
    



