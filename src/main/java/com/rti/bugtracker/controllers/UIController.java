package com.rti.bugtracker.controllers;

import com.rti.bugtracker.domain.DCIssues;
import com.rti.bugtracker.domain.DCIssuesEntity;
import com.rti.bugtracker.util.SearchRequestData;
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
//@RequestMapping(value = "/ui")
public class UIController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private DCIssues dcIssues;

    @Autowired
    public UIController(DCIssues dcIssues) {
        this.dcIssues = dcIssues;
    }

    public UIController() {}

    /**
     * Need a POST method to take the Admin Display Issues form and build a search string which will be used
     * to get all the requested issues and pass them to the page for display.
     */


    @RequestMapping(value = "/", method=RequestMethod.GET, produces="application/json")
    public String getIndex(Model model) {
        log.info("About to load home page");
        return "index";
    }


    //@GetMapping("/getissues")
    @RequestMapping(value = "/getissues", method = RequestMethod.GET, headers = "content_type=application/json")
    public  String adminDisplayFormPage(Model model) {
        //Map<String,Object> model = new HashMap<String,Object>();

        List<DCIssuesEntity> issues = new ArrayList<>();
        log.info("About to get problem types and assigned users");
        model.addAttribute("problems", dcIssues.findProblemTypes());
        model.addAttribute("assignedUsers", dcIssues.findAssignedUsers());
        SearchRequestData searchData = new SearchRequestData(null, null, null);

        return "admindisplayform";
    }

    /*
    //@PostMapping("/getissues")
    @RequestMapping(value = "/admindisdplayform", method = RequestMethod.POST,  headers = "content_type=application/json")
    public String showIssues(Model model) {

        return "admindisplayissues";
    }
    */
}
