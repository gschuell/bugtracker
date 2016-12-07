package com.rti.bugtracker.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gschuell on 11/14/16.
 */
@Controller
@RequestMapping(value = "/issues")
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

    /*
    @RequestMapping(value = "/", method=RequestMethod.GET, produces="application/json")
    public String getIndex() {
        log.info("About to load home page");
        return "index";
    }
   */
/*
    //@GetMapping("/getissues")
    @RequestMapping(value = "/getissues", method = RequestMethod.GET, headers = "content_type=application/json")
    public  String adminDisplayFormPage(Model model) {
        //Map<String,Object> model = new HashMap<String,Object>();

        List<DCIssuesEntity> issues = new ArrayList<>();
        log.info("About to get problem types and assigned users");
        model.addAttribute("problems", issuesController.getProblemTypes());
        model.addAttribute("assignedUsers", issuesController.findAssignedUsers());
        SearchRequestData searchData = new SearchRequestData(null, null, null);

        return "admindisplayform";
    }
*/
    /*
    //@PostMapping("/getissues")
    @RequestMapping(value = "/admindisdplayform", method = RequestMethod.POST,  headers = "content_type=application/json")
    public String showIssues(Model model) {

        return "admindisplayissues";
    }
    */
}
