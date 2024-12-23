package com.neoteric.dec_dbconnection.customannotations;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class MyService {
 @MyAnnotation
    public String processRequest(String input , HttpServletRequest servletRequest){
    String clientIP = servletRequest.getRemoteAddr();
      return "process Request" + input + " ip" + clientIP;
    }

    @MyAnnotation
    public String processRequest(String input){
        return "process Request" ;
    }


}
