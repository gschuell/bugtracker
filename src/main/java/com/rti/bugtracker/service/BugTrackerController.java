package com.rti.bugtracker.service;

import com.rti.bugtracker.domain.AmrIssues;
import com.rti.bugtracker.domain.AmrIssuesEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gschuell on 10/17/16.
 */
@RestController
@RequestMapping(value = "/issues")
public class BugTrackerController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    private AmrIssues amrIssues;

    @Autowired
    public BugTrackerController(AmrIssues amrIssues) {
        this.amrIssues = amrIssues;
        log.info("Entering BugTrackerController constructor armIssues = [{}]", this.amrIssues.findOne((long)496));
    }

    public BugTrackerController() {}


    @RequestMapping(value = "/{bugId}", method = RequestMethod.GET, produces = "application/json")
    public AmrIssuesEntity showIssue(@PathVariable("bugId") long bugId ) {
        log.info("Looking for a bug entry with id {}", bugId);
        return amrIssues.findOne(bugId);
    }

    @RequestMapping(value = "/allissues", method = RequestMethod.GET, produces = "application/json")
    public List<AmrIssuesEntity> showAllIssues() {
        log.info("Value of amrIssues [{}]", amrIssues);
        System.out.println("Value of armIssues [" + amrIssues + "]");
        return amrIssues.findAll();
    }

}
