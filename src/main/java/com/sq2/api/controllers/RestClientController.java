package com.sq2.api.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RestClientController {


    @GetMapping
    public ModelAndView redirectToClient(){
     return new ModelAndView("redirect:" + "http://ui-tekton-argocd-sq-2.cohort2bootcamp-6ccd7f378ae819553d37d5f2ee142bd6-0000.us-south.containers.appdomain.cloud");
    }
}
