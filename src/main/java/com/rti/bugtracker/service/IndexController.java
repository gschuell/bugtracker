package com.rti.bugtracker.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gschuell on 12/6/16.
 */
@Controller@RequestMapping("/issues")
public class IndexController {

    @RequestMapping("/")
    public String getIndex() {

        return "index";
    }
}
