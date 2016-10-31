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
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gschuell on 10/17/16.
 */
@RestController
@RequestMapping(value = "/issues")
public class AmrIssuesController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    private AmrIssues amrIssues;

    @Autowired
    public AmrIssuesController(AmrIssues amrIssues) {
        this.amrIssues = amrIssues;
        log.debug("Entering BugTrackerController constructor armIssues.");
    }

    public AmrIssuesController() {}

    @RequestMapping(method = RequestMethod.GET)
    public String showMenu() {
        ModelAndView model = new ModelAndView("index");
        return "index";
    }

    /**
     *
     * @param bugId
     * @return AmrIssuesEntity
     */

    @RequestMapping(value = "/{bugId}", method = RequestMethod.GET, produces = "application/json")
    public AmrIssuesEntity showIssue(@PathVariable("bugId") long bugId ) {
        log.debug("Looking for a bug entry with id {}", bugId);
        return amrIssues.findOne(bugId);
    }

    @RequestMapping(value = "/allissues", method = RequestMethod.GET, produces = "application/json")
    public List<AmrIssuesEntity> showAllIssues() {
        log.debug("Value of amrIssues [{}]", amrIssues);
        List<AmrIssuesEntity> issues = new ArrayList<>(amrIssues.findAll());
        return (List<AmrIssuesEntity>) issues.parallelStream().sorted((AmrIssuesEntity e1,
                           AmrIssuesEntity e2) ->(int)e1.getBugId() - ((int)e2.getBugId()))
                           .collect(Collectors.toList());

    }

    @RequestMapping(value = "/byuser/{userLogin}", method = RequestMethod.GET, produces = "application/json")
    public List<AmrIssuesEntity> findByUserLogin(@PathVariable("userLogin") String userLogin) {
        List<AmrIssuesEntity> issues = new ArrayList<>(amrIssues.findByUserLogin(userLogin.toUpperCase()));
        if (issues.size() > 1)
            return (List<AmrIssuesEntity>)issues.parallelStream().sorted((AmrIssuesEntity e1,
                          AmrIssuesEntity e2) ->(int)e1.getBugId() - ((int)e2.getBugId()))
                          .collect(Collectors.toList());
        return issues;
    }

    /**
     * This endpoint returns a list of users contained in the userLogin column of the AMR_ISSUES
     * table in the BUGSADMIN database. The underlying SQL uses the distinct keyword to only return
     * unique users. A call to this endpoint will be to populate a drop down list to use to view
     * issues by a given user.
     *
     * @return List of unique users
     */
    @RequestMapping(value = "/loginusers", method = RequestMethod.GET, produces = "application/json")
    public List<String> findUserLogins() {
        List<String> users = new ArrayList<String>(amrIssues.findUserLogins());
        if (users.size() > 1)
            return (List<String>)users.parallelStream().sorted((String e1,String e2) ->(e1.compareToIgnoreCase(e2)))
                               .collect(Collectors.toList());
        return users;
    }


}
