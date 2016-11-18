package com.rti.bugtracker.service;

import com.rti.bugtracker.domain.AmrIssues;
import com.rti.bugtracker.domain.AmrIssuesEntity;
import com.rti.bugtracker.util.AmrIssuesComparatorStore;
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
public class AmrIssuesController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public enum SortTypes {
        BUGID,
        CATEGORY,
        STATUS
    }


    private AmrIssues amrIssues;

    private AmrIssuesComparatorStore amrIssuesComparatorStore;

    @Autowired
    public AmrIssuesController(AmrIssues amrIssues) {
        this.amrIssues = amrIssues;
       // this.amrIssuesComparatorStore = amrIssuesComparatorStore;
        log.info("Entering BugTrackerController constructor armIssues.");
    }

    public AmrIssuesController() {}
    
    /**
     * This endpoint accepts a bug ID and returns the bug in JSON format. If no bug exists,
     * null will be returned.
     *
     * @param bugId
     * @return AmrIssuesEntity
     */

    @RequestMapping(value = "/{bugId}", method = RequestMethod.GET, produces = "application/json")
    public AmrIssuesEntity showIssue(@PathVariable("bugId") long bugId ) {
        log.info("Looking for a bug entry with id {}", bugId);
        return amrIssues.findOne(bugId);
    }

    /**
     * This endpoint returns all of the issues in the BUGSADMIN.AMR_ISSUES table sorted by
     * bugId.
     *
     * @return List<AmrIssuesEntity>
     */

    @RequestMapping(value = "/allissues", method = RequestMethod.GET, produces = "application/json")
    public List<AmrIssuesEntity> showAllIssues() {
        log.info("Starting allIssues");
        long startTime = System.currentTimeMillis();
        List<AmrIssuesEntity> issues = new ArrayList<>(amrIssues.findAll());
        Comparator<AmrIssuesEntity> comparator = getComparator(SortTypes.BUGID);
         //       (e1, e2) -> ( e1.getBugCategory().compareToIgnoreCase(e2.getBugCategory()));
        //log.info("Sorting results on sort type {}", comparators.getComparator(sortType).toString());
       // Comparator<AmrIssuesEntity> idComparator = (e1, e2) -> ((int) e1.getBugId() - (int) e2.getBugId());
       // return issues;

        //List<AmrIssuesEntity> issuesList = amrIssues.findAllByOrderByBugIdAsc();


       List<AmrIssuesEntity> issuesList = issues.parallelStream().sorted(comparator)
                   .collect(Collectors.toList());
        log.info("Select finished allissues in [{}] milliseconds.", System.currentTimeMillis() - startTime);
        return issuesList;
    }

    /**
     * This endpoint lsits all bugs for a userLogin. A user will select a user from a dropdown list
     * populated by the /loginuser endpoint referenced below. ThSis endpoint will return a list of
     * AmrIssuesEntity objects sorted by bugId.
     * @param userLogin
     * @return List<AmrIssuesEntity>
     */

    @RequestMapping(value = "/byuser/{userLogin}", method = RequestMethod.GET, produces = "application/json")
    public List<AmrIssuesEntity> findByUserLogin(@PathVariable("userLogin") String userLogin) {
        List<AmrIssuesEntity> issues = new ArrayList<>(amrIssues.findByUserLogin(userLogin.toUpperCase()));
        if (issues.size() > 1)
            return issues.parallelStream().sorted((AmrIssuesEntity e1,
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
     * @return List of unique users List<String>
     */
    @RequestMapping(value = "/loginusers", method = RequestMethod.GET, produces = "application/json")
    public List<String> findUserLogins() {
        List<String> users = new ArrayList<String>(amrIssues.findUserLogins());
        if (users.size() > 1)
            return users.parallelStream().sorted((String e1,String e2) ->(e1.compareToIgnoreCase(e2)))
                               .collect(Collectors.toList());
        return users;
    }

    public Comparator<AmrIssuesEntity> getComparator(SortTypes type) {

        Comparator<AmrIssuesEntity> comparator;

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
