package com.rti.bugtracker.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by gschuell on 12/6/16.
 */
@Controller
@RequestMapping("/DCBugs")
public class IndexController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

   // private static final String PATH = "/error";
/*
    @RequestMapping("/error")
    public String error() {

        return "Error Handling";
    }
*/
    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String getIndex() {
        log.info("About to load home page");
       // if (model.getView() == null) {
       //     model = new ModelAndView("index");
       // }
        return "index";
    }

  //  @Override
  //  public String getErrorPath() {
    //    return PATH;
   // }
}
