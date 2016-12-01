package com.rti.bugtracker.service;

import com.rti.bugtracker.domain.DCIssuesEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gschuell on 11/14/16.
 */
@Controller
@RequestMapping(value = "issues/")
public class UIController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private DCIssuesController issuesController;

    @Autowired
    public UIController(DCIssuesController issuesController) {
        this.issuesController = issuesController;
    }

    public UIController() {}

    /**
     * Need a POST method to take the Admin Display Issues form and build a search string which will be used
     * to get all the requested issues and pass them to the page for display.
     */


    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public  String index(Model model) {
        //Map<String,Object> model = new HashMap<String,Object>();
        List<DCIssuesEntity> issues = new ArrayList<>();
        model.addAttribute("issues", issuesController.showAllIssues());

        return "admindisplayform.html";
    }

    @RequestMapping(value = "admindisplayissues", method = RequestMethod.POST, consumes = "application/json")
    public String
}
