package com.rti.bugtracker.service;

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


    @RequestMapping(value = "/")
    public String getIndex() {
        log.info("About to load home page");
        return "index";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greetings(Model model) {
        log.info("about to load greeting page");
        model.addAttribute("greeting", new DCIssuesEntity());
        return "greeting";
    }


    //@GetMapping("/getissues")
    @RequestMapping(value = "/admindisplayform", method = RequestMethod.GET, headers = "content_type=application/json")
    public  String adminDisplayFormPage(Model model) {
        //Map<String,Object> model = new HashMap<String,Object>();

        List<DCIssuesEntity> issues = new ArrayList<>();
        model.addAttribute("problems", issuesController.getProblemTypes());
        model.addAttribute("assignedUsers", issuesController.findAssignedUsers());
        SearchRequestData searchData = new SearchRequestData(null, null, null);

        return "admindisplayform";
    }

    //@PostMapping("/getissues")
    @RequestMapping(value = "/admindisdplayform", method = RequestMethod.POST,  headers = "content_type=application/json")
    public String showIssues(Model model) {

        return "admindisplayissues";
    }
}
