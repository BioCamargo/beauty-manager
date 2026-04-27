package br.com.studio.beautymanager.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {

    public String extrairToken(HttpServletRequest request){

        String header = request.getHeader("Authorization");

        if(header != null && header.startsWith("Bearer ")){

            return header.substring(7);

        }

        return null;

    }

}