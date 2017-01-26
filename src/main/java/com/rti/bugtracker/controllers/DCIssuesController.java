package com.rti.bugtracker.controllers;

import com.rti.bugtracker.domain.*;
import com.rti.bugtracker.util.DCIssuesComparatorStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
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
    private DCCategory dcCategory;
    private DCDeveloperNames dcDeveloperNames;

    private DCIssuesComparatorStore dcIssuesComparatorStore;

    @Autowired
    public DCIssuesController(DCIssues dcIssues, DCCategory dcCategory, DCDeveloperNames dcDeveloperNames) {
        log.info("Entering DCIssuesController constructor dcIssues.");
        this.dcIssues = dcIssues;
        this.dcCategory = dcCategory;
        this.dcDeveloperNames = dcDeveloperNames;
       // this.dcIssuesComparatorStore = dcIssuesComparatorStore;

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
    public List<DCIssuesEntity> showIssue(@PathVariable("bugId") long bugId ) {
        log.info("Looking for a bug entry with id {}", bugId);
        return dcIssues.findOneSingleIssue(bugId);
    }

    /**
     * This endpoint returns all of the dcIssues in the BUGSADMIN.AMR_dcIssues table sorted by
     * bugId.
     *
     * @return List<DCIssuesEntity>
     */

    @RequestMapping(value = "/allIssues", method = RequestMethod.GET, produces = "application/json")
    public List<DCIssuesEntity> showAllIssues() {
        log.info("Starting allIssues");
        long startTime = System.currentTimeMillis();
        List<DCIssuesEntity> dcIssuesList = new ArrayList<>(dcIssues.findAll());
        Comparator<DCIssuesEntity> comparator = getComparator(SortTypes.BUGID);
         //       (e1, e2) -> ( e1.getBugCategory().compareToIgnoreCase(e2.getBugCategory()));
        //log.info("Sorting results on sort type {}", comparators.getComparator(sortType).toString());
       // Comparator<dcIssuesEntity> idComparator = (e1, e2) -> ((int) e1.getBugId() - (int) e2.getBugId());
       // return dcIssues;

        //List<dcIssuesEntity> dcIssuesList = DCIssues.findAllByOrderByBugIdAsc();


       dcIssuesList = dcIssuesList.parallelStream().sorted(comparator)
                   .collect(Collectors.toList());
        log.info("Select finished allIssues in [{}] milliseconds.", System.currentTimeMillis() - startTime);
        return dcIssuesList;
    }

    @RequestMapping(value = "/update/{issueId}", method = RequestMethod.PUT)
    public DCIssuesEntity saveIssue(@PathVariable(value = "issueId") long issueId,
                                    @RequestBody DCIssuesEntity issue) {

        return dcIssues.save(issue);
    }

    /**
     * This endpoint lsits all bugs for a userLogin. A user will select a user from a dropdown list
     * populated by the /loginuser endpoint referenced below. ThSis endpoint will return a list of
     * dcIssuesEntity objects sorted by bugId.
     * @param assignedTo
     * @return List<dcIssuesEntity>
     */

    @RequestMapping(value = "/byuser/{assignedTo}", method = RequestMethod.GET, produces = "application/json")
    public List<DCIssuesEntity> findByAssignedTo(@PathVariable("assignedTo") String assignedTo) {
        //log.info("Looking for Issues assigned to {}", assignedTo);
        List<DCIssuesEntity> dcIssuesList = new ArrayList<>(dcIssues.findByAssignedTo(assignedTo));
        if (dcIssuesList.size() > 1)
            return dcIssuesList.parallelStream().filter(Objects::nonNull).sorted((DCIssuesEntity e1,
                          DCIssuesEntity e2) ->(int)e1.getBugId() - ((int)e2.getBugId()))
                          .collect(Collectors.toList());
        return dcIssuesList;
    }

    @RequestMapping(value = "/bycategory/{category}", method = RequestMethod.GET, produces = "application/json")
    public List<DCIssuesEntity> findByCategory(@PathVariable("category") String assignedTo) {
        //log.info("Looking for Issues assigned to {}", assignedTo);
        List<DCIssuesEntity> dcIssuesList = new ArrayList<>(dcIssues.findByAssignedTo(assignedTo));
        if (dcIssuesList.size() > 1)
            return dcIssuesList.parallelStream().filter(Objects::nonNull).sorted((DCIssuesEntity e1,
                                                                                  DCIssuesEntity e2) ->(int)e1.getBugId() - ((int)e2.getBugId()))
                    .collect(Collectors.toList());
        return dcIssuesList;
    }

    @RequestMapping(value = "/bystatus/{bugStatus}", method = RequestMethod.GET, produces = "application/json")
    public List<DCIssuesEntity> findAllIssuesByBugStatus(@PathVariable("bugStatus") String bugStatus) {

        List<DCIssuesEntity> dcIssuesList = new ArrayList<>(dcIssues.findAllIssuesByBugStatus(bugStatus));
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
    @RequestMapping(value = "/assignedusers", method = RequestMethod.GET, produces = "application/json")
    public List<String> findAssignedUsers() {

        List<String> users = new ArrayList<String>(dcIssues.findAssignedUsers());
        //log.info("There are {} rows returned", users.size());
        if (users.size() > 1)
            return users.parallelStream().filter(Objects::nonNull).sorted((String e1, String e2) ->(e1.compareToIgnoreCase(e2)))
                               .collect(Collectors.toList());
        return users;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = "application/json")
    public List<String> getCategories() {
        List<DCCategoriesEntity> categories = dcCategory.findAll();
        List<String> catNames = new ArrayList<>();
        for (DCCategoriesEntity cat : categories) {
            catNames.add(cat.getCategoryName());
        }

        if (catNames.size() > 1) {
            return catNames.stream().filter(Objects::nonNull)
                    .sorted((String e1, String e2) -> (e1.compareToIgnoreCase(e2)))
                    .collect(Collectors.toList());
        }
        return catNames;

    }

    @RequestMapping(value = "/resolutiontypes", method = RequestMethod.GET, produces = "application/json")
    public List<DCCategoriesEntity> getResolutionTypes() {

        List<DCCategoriesEntity> resolutions = dcCategory.findAll();
        return resolutions.stream().filter(Objects::nonNull)
                .sorted((DCCategoriesEntity e1, DCCategoriesEntity e2) -> e1.getCategoryId() - e2.getCategoryId())
                .collect(Collectors.toList());

    }

    @RequestMapping(value = "/problemtype", method = RequestMethod.GET, produces = "application/json")
    public List<String> getProblemTypes() {

        List<String> problems = dcIssues.findProblemTypes();
        return problems.stream().filter(Objects::nonNull)
                .collect(Collectors.toList());

    }

    @RequestMapping(value = "/developers", method = RequestMethod.GET, produces = "application/json")
    public List<DCDeveloperNamesEntity> getDeveloperNames() {

        List<DCDeveloperNamesEntity> devNames = dcDeveloperNames.findAll();
        return devNames.stream().filter(Objects::nonNull).collect(Collectors.toList());

    }

    @RequestMapping(value = "/statusand")
    List<DCIssuesEntity> findAllIssuesByBugStatusAndPayorId(String bugStatus, String payorId) {

        return null;
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
