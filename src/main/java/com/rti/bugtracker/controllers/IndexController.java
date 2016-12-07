package com.rti.bugtracker.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gschuell on 12/6/16.
 */
@Controller
@RequestMapping("/issues")
public class IndexController implements ErrorController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String PATH = "/error";

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String getIndex() {
        log.info("About to load home page");
        return "index";
    }

    @RequestMapping( value = PATH )
    public String error() {
        return "Error Handling";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }


}
