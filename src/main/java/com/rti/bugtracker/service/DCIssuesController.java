package com.rti.bugtracker.service;

import com.rti.bugtracker.domain.DCIssues;
import com.rti.bugtracker.domain.DCIssuesEntity;
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


    private DCIssues dcIssues;

    private DCIssuesComparatorStore DCdcIssuesComparatorStore;

    @Autowired
    public DCIssuesController(DCIssues dcIssues) {
        this.dcIssues = dcIssues;
       // this.DCdcIssuesComparatorStore = DCdcIssuesComparatorStore;
        log.info("Entering BugTrackerController constructor armdcIssues.");
    }

    public DCIssuesController() {}
    
    /**
     * This endpoint accepts a bug ID and returns the bug in JSON format. If no bug exists,
     * null will be returned.
     *
     * @param bugId
     * @return DCIssuesEntity
     */

    @RequestMapping(value = "/{bugId}", method = RequestMethod.GET, produces = "application/json")
    public DCIssuesEntity showIssue(@PathVariable("bugId") long bugId ) {
        log.info("Looking for a bug entry with id {}", bugId);
        return dcIssues.findOne(bugId);
    }

    /**
     * This endpoint returns all of the dcIssues in the BUGSADMIN.AMR_dcIssues table sorted by
     * bugId.
     *
     * @return List<DCIssuesEntity>
     */

    @RequestMapping(value = "/alldcIssues", method = RequestMethod.GET, produces = "application/json")
    public List<DCIssuesEntity> showAlldcIssues() {
        log.info("Starting alldcIssues");
        long startTime = System.currentTimeMillis();
        List<DCIssuesEntity> dcIssuesList = new ArrayList<>(dcIssues.findAll());
        Comparator<DCIssuesEntity> comparator = getComparator(SortTypes.BUGID);
         //       (e1, e2) -> ( e1.getBugCategory().compareToIgnoreCase(e2.getBugCategory()));
        //log.info("Sorting results on sort type {}", comparators.getComparator(sortType).toString());
       // Comparator<dcIssuesEntity> idComparator = (e1, e2) -> ((int) e1.getBugId() - (int) e2.getBugId());
       // return dcIssues;

        //List<dcIssuesEntity> dcIssuesList = DCdcIssues.findAllByOrderByBugIdAsc();


       dcIssuesList = dcIssuesList.parallelStream().sorted(comparator)
                   .collect(Collectors.toList());
        log.info("Select finished alldcIssues in [{}] milliseconds.", System.currentTimeMillis() - startTime);
        return dcIssuesList;
    }

    /**
     * This endpoint lsits all bugs for a userLogin. A user will select a user from a dropdown list
     * populated by the /loginuser endpoint referenced below. ThSis endpoint will return a list of
     * dcIssuesEntity objects sorted by bugId.
     * @param userLogin
     * @return List<dcIssuesEntity>
     */

    @RequestMapping(value = "/byuser/{userLogin}", method = RequestMethod.GET, produces = "application/json")
    public List<DCIssuesEntity> findByUserLogin(@PathVariable("userLogin") String userLogin) {
        List<DCIssuesEntity> dcIssuesList = new ArrayList<>(dcIssues.findByAssignedTo(userLogin.toUpperCase()));
        if (dcIssuesList.size() > 1)
            return dcIssuesList.parallelStream().sorted((DCIssuesEntity e1,
                          DCIssuesEntity e2) ->(int)e1.getBugId() - ((int)e2.getBugId()))
                          .collect(Collectors.toList());
        return dcIssuesList;
    }

    /**
     * This endpoint returns a list of users contained in the userLogin column of the AMR_dcIssues
     * table in the BUGSADMIN database. The underlying SQL uses the distinct keyword to only return
     * unique users. A call to this endpoint will be to populate a drop down list to use to view
     * dcIssues by a given user.
     *
     * @return List of unique users List<String>
     */
    @RequestMapping(value = "/loginusers", method = RequestMethod.GET, produces = "application/json")
    public List<String> findUserLogins() {
        List<String> users = new ArrayList<String>(dcIssues.findAssignedUsers());
        if (users.size() > 1)
            return users.parallelStream().sorted((String e1,String e2) ->(e1.compareToIgnoreCase(e2)))
                               .collect(Collectors.toList());
        return users;
    }

    public Comparator<DCIssuesEntity> getComparator(SortTypes type) {

        Comparator<DCIssuesEntity> comparator;

        switch(type) {
            case BUGID :
                return  comparator =
                    (e1, e2) -> ( (int)e1.getBugId() - ((int)e2.getBugId()));
            case CATEGORY :
                return  comparator =
                        (e1, e2) -> ( e1.getProblemType().compareToIgnoreCase(e2.getProblemType()));
            case STATUS :
                return  comparator =
                        (e1, e2) -> (e1.getBugStatus().compareToIgnoreCase(e2.getBugStatus()));
        }

        return null;
    }

}
