package com.rti.bugtracker.controllers;

import com.rti.bugtracker.bizlogic.AdminDisplayForm;
import com.rti.bugtracker.bizlogic.DBUtils;
import com.rti.bugtracker.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by gschuell on 12/7/16.
 */
@Controller
@RequestMapping("/DCBugs")
public class IssueController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    DCCategory dcCategory;
    DCDeveloperNames dcDeveloperNames;
    DCIssues dcIssues;
    DBUtils dbUtils;


    @Autowired
    public IssueController(DCCategory dcCategory, DCDeveloperNames dcDeveloperNames,
                           DCIssues dcIssues, DBUtils dbUtils) {
        this.dcCategory = dcCategory;
        this.dcDeveloperNames = dcDeveloperNames;
        this.dcIssues = dcIssues;
        this.dbUtils = dbUtils;

    }

    @RequestMapping(value = "/getissues", method= RequestMethod.GET, produces="application/json")
    public ModelAndView adminDisplayFormPage(ModelAndView model) {

        if (model.getView() == null) {
            model = new ModelAndView("admindisplayform");
        }
        log.info("About to get problem types and assigned users");
        model.addObject("problems",  dcCategory.findCategoryNames());
        model.addObject("assignedUsers", dcIssues.findAssignedUsers());
        model.addObject("statuses", BugStatusValues.getStatuses());
        model.addObject("admindisplayform", new AdminDisplayForm());


        return model;
    }

    @RequestMapping(value = "/admindisplaydata", method = RequestMethod.POST )
    public ModelAndView displayIssuesData(@ModelAttribute(value = "admindisplayform)") AdminDisplayForm issuesForm) {
        ModelAndView model = new ModelAndView("admindisplaydata");
        List<DCIssuesEntity> issues = dbUtils.getIssuesData(issuesForm);
        // Don't filter data is an issue id was selected as only a singleton is returned
        if (issuesForm.getIssueId().equals("All")) {
            issues = dbUtils.filterData(issues, issuesForm);
        }

        model.addObject("issuesList", issues);

        return model;
    }

    @RequestMapping(value = "/adminupdateissue/{issueId}", method = RequestMethod.GET )
    public String displayUpdatePage(@PathVariable long issueId, Model model) {

        model.addAttribute("issueData",dcIssues.findOne(issueId));
        model.addAttribute("problems",  dcIssues.findProblemTypes());
        model.addAttribute("assignedUsers", dcIssues.findAssignedUsers());
        model.addAttribute("developerNames", dcDeveloperNames.findDeveloperNames());
        model.addAttribute("statuses", BugStatusValues.getStatuses());
        model.addAttribute("priority", BugStatusValues.getPriority());
        model.addAttribute("userId", System.getProperty("user.name"));

        return "redirect:/adminupdateissue";
    }

    @RequestMapping(value = "/adminupdateissue/update", method = RequestMethod.POST)
    public String updateIssue(DCIssuesEntity issueData) {


       // DCIssuesData issue = (DCIssuesData)modelData.get("issueData");
        log.info("About to update issue {}", issueData.getBugId());
        dcIssues.save(issueData);

        return "redirect:/DCBugs/getissues"; // for now
    }

    @RequestMapping(value = "/showusers", method = RequestMethod.GET)
    public ModelAndView showUsers() {

        ModelAndView model = new ModelAndView();
        model.setViewName("showusers");
        model.addObject("users", dcDeveloperNames.findAll());
        return model;
    }

    @RequestMapping(value = "/showresolutiontypes", method = RequestMethod.GET)
    public ModelAndView showResolutionTypes() {

        ModelAndView model = new ModelAndView();
        model.setViewName("showresolutiontypes");
        List<DCCategoriesEntity> categories = dcCategory.findAll();
        model.addObject("resolutions", categories);

        return model;
    }


}
