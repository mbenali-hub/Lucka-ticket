package com.benali.feign;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.benali.config.TokenContext;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class Interceptor implements RequestInterceptor{

    
    private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

    @Override
    public void apply(RequestTemplate template) {
        // String token = TokenContext.getToken();
        // if (token != null) {
        //     template.header("Authorization", token);
        // } else {
        //     // útil para debug
        //     throw new IllegalStateException("Token es nulo al llamar Feign");
        // }

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes!=null){
            String token = attributes.getRequest().getHeader("Authorization");
            if(token!=null && token.startsWith("Bearer ")){
                template.header("Authorization", token);
                System.out.println("tOKEN EN RECEPTOR: "+ token);
            }
        }
    }

}
