package com.neoteric.dec_dbconnection.customannotations;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomAnnotationController {

    MyService service;

    @Autowired
    public  CustomAnnotationController(MyService service) {
        this.service = service;
    }
    @PostMapping("/process")
    public String process(String input){
        return service.processRequest(input);
  }
}
