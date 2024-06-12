package dev.ashiq.productServicettsevening.filters;


//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//            String username = (String) request.getAttribute("username");
//            String roles = (String) request.getAttribute("roles");
//
//            if (username != null && roles != null) {
//                Collection<? extends GrantedAuthority> authorities = Arrays.stream(roles.split(","))
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//                PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(
//                        username, null, authorities);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//
//            filterChain.doFilter(request, response);
//        }
//    }
//
//
