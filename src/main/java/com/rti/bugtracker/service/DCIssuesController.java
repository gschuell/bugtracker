package com.rti.bugtracker.service;

import com.rti.bugtracker.domain.DCIssues;
import com.rti.bugtracker.domain.IssuesEntity;
import com.rti.bugtracker.domain.IssuesEntity;
import com.rti.bugtracker.util.DCIssuesComparatorStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gschuell on 10/17/16.
 */
@RestController
@RequestMapping(value = "/issues")
public class DCIssuesController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public enum SortTypes {
        BUGID,
        CATEGORY,
        STATUS
    }


    private Issues Issues;

    private DCIssuesComparatorStore DCIssuesComparatorStore;

    @Autowired
    public DCIssuesController(DCIssues DCIssues) {
        this.Issues = Issues;
       // this.DCIssuesComparatorStore = DCIssuesComparatorStore;
        log.info("Entering BugTrackerController constructor armIssues.");
    }

    public DCIssuesController() {}
    
    /**
     * This endpoint accepts a bug ID and returns the bug in JSON format. If no bug exists,
     * null will be returned.
     *
     * @param bugId
     * @return IssuesEntity
     */

    @RequestMapping(value = "/{bugId}", method = RequestMethod.GET, produces = "application/json")
    public IssuesEntity showIssue(@PathVariable("bugId") long bugId ) {
        log.info("Looking for a bug entry with id {}", bugId);
        return Issues.findOne(bugId);
    }

    /**
     * This endpoint returns all of the issues in the BUGSADMIN.AMR_ISSUES table sorted by
     * bugId.
     *
     * @return List<IssuesEntity>
     */

    @RequestMapping(value = "/allissues", method = RequestMethod.GET, produces = "application/json")
    public List<IssuesEntity> showAllIssues() {
        log.info("Starting allIssues");
        long startTime = System.currentTimeMillis();
        List<IssuesEntity> issues = new ArrayList<>(DCIssues.findAll());
        Comparator<IssuesEntity> comparator = getComparator(SortTypes.BUGID);
         //       (e1, e2) -> ( e1.getBugCategory().compareToIgnoreCase(e2.getBugCategory()));
        //log.info("Sorting results on sort type {}", comparators.getComparator(sortType).toString());
       // Comparator<IssuesEntity> idComparator = (e1, e2) -> ((int) e1.getBugId() - (int) e2.getBugId());
       // return issues;

        //List<IssuesEntity> issuesList = DCIssues.findAllByOrderByBugIdAsc();


       List<IssuesEntity> issuesList = issues.parallelStream().sorted(comparator)
                   .collect(Collectors.toList());
        log.info("Select finished allissues in [{}] milliseconds.", System.currentTimeMillis() - startTime);
        return issuesList;
    }

    /**
     * This endpoint lsits all bugs for a userLogin. A user will select a user from a dropdown list
     * populated by the /loginuser endpoint referenced below. ThSis endpoint will return a list of
     * IssuesEntity objects sorted by bugId.
     * @param userLogin
     * @return List<IssuesEntity>
     */

    @RequestMapping(value = "/byuser/{userLogin}", method = RequestMethod.GET, produces = "application/json")
    public List<IssuesEntity> findByUserLogin(@PathVariable("userLogin") String userLogin) {
        List<IssuesEntity> issues = new ArrayList<>(Issues.findByUserLogin(userLogin.toUpperCase()));
        if (issues.size() > 1)
            return issues.parallelStream().sorted((IssuesEntity e1,
                          IssuesEntity e2) ->(int)e1.getBugId() - ((int)e2.getBugId()))
                          .collect(Collectors.toList());
        return issues;
    }

    /**
     * This endpoint returns a list of users contained in the userLogin column of the AMR_ISSUES
     * table in the BUGSADMIN database. The underlying SQL uses the distinct keyword to only return
     * unique users. A call to this endpoint will be to populate a drop down list to use to view
     * issues by a given user.
     *
     * @return List of unique users List<String>
     */
    @RequestMapping(value = "/loginusers", method = RequestMethod.GET, produces = "application/json")
    public List<String> findUserLogins() {
        List<String> users = new ArrayList<String>(DCIssues.findUserLogins());
        if (users.size() > 1)
            return users.parallelStream().sorted((String e1,String e2) ->(e1.compareToIgnoreCase(e2)))
                               .collect(Collectors.toList());
        return users;
    }

    public Comparator<IssuesEntity> getComparator(SortTypes type) {

        Comparator<IssuesEntity> comparator;

        switch(type) {
            case BUGID :
                return  comparator =
                    (e1, e2) -> ( (int)e1.getBugId() - ((int)e2.getBugId()));
            case CATEGORY :
                return  comparator =
                        (e1, e2) -> ( e1.getBugCategory().compareToIgnoreCase(e2.getBugCategory()));
            case STATUS :
                return  comparator =
                        (e1, e2) -> (e1.getBugStatus().compareToIgnoreCase(e2.getBugStatus()));
        }

        return null;
    }

}
