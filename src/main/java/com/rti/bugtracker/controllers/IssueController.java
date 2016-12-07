package com.rti.bugtracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gschuell on 12/7/16.
 */
@Controller
@RequestMapping("/issue")
public class IssueController {

    @RequestMapping("/getissues")
    public String getIssues(Model model) {

        return "admindisplayform";
    }
}
