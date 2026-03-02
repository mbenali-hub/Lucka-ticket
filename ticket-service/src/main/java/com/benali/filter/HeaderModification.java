package com.benali.filter;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import com.benali.config.TokenContext;
import com.benali.feign.Interceptor;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
// public class HeaderModification extends OncePerRequestFilter{
//     private final TokenContext tokenContext;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)  throws ServletException, IOException {
//         try{
//             String token = getToken(request);       
//             System.out.println("El token obtendio en el filtro es : "+ token);
//             tokenContext.setToken(token); 
//             System.out.println("rECUPERAR TOKEN DEL CONTEXTO: "+ tokenContext.getToken());

//             filterChain.doFilter(request, response);
//         }catch(Exception e){}
//         finally{
//            // tokenContext.clear();
//         }
        
//     }

   
//     private String getToken(HttpServletRequest request){
//         String token = "";

//         String bearer = request.getHeader("Authorization");
//         if(bearer!=null&&bearer.startsWith("Bearer ")){
//             token = bearer.substring(7);
//         }
//     return token;
// }
// }
