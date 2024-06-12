package dev.ashiq.productServicettsevening.secuirty;

//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("//products-db/paginated").hasRole("Admin")
////                        .requestMatchers("/user/**").hasRole("USER")
//                        .anyRequest().authenticated()
//                );
//        return http.build();
//    }
//}