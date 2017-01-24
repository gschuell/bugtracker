package com.rti.bugtracker.bizlogic;

import com.rti.bugtracker.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by gschuell on 12/12/16.
 */
@Component
public class DBUtils {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    DCCategory dcCategory;
    DCDeveloperNames dcDeveloperNames;
    DCIssues dcIssues;

    public DBUtils(DCCategory dcCategory, DCDeveloperNames dcDeveloperNames, DCIssues dcIssues) {

        this.dcCategory = dcCategory;
        this.dcDeveloperNames = dcDeveloperNames;
        this.dcIssues = dcIssues;
    }


    public List<String> getProblemTypes() {

        List<String> problems = dcIssues.findProblemTypes();

        List<String> problemList = new ArrayList<>();
        for (String probStr : problems) {
            problemList.add(probStr);
        }

        return problemList;

    }

    public List<DCCategoriesEntity> getResolutionTypes() {

        List<DCCategoriesEntity> resolutions = dcCategory.findAll();
        for (DCCategoriesEntity resolution : resolutions) {
            resolutions.add(resolution);
        }

        return resolutions;

    }


    public List<String> getAssignedUsers() {

        return dcIssues.findAssignedUsers();
    }

    public List<DCDeveloperNamesEntity> getUsers() {

        return dcDeveloperNames.findAll();
    }


    public void updateIssue(DCIssuesEntity issue) {

        Map<String, String> map = new HashMap<String, String>();
        String issueId = String.valueOf(issue.getBugId());
        map.put("issueId", issueId);

        dcIssues.save(issue);

    }


    public List<DCIssuesEntity> getIssuesData(AdminDisplayForm searchArgs) {

        List<DCIssuesEntity> issuesList = null;

        if (!searchArgs.getIssueId().equals("All")) {

            issuesList = dcIssues.findOneSingleIssue(Long.parseLong(searchArgs.getIssueId()));
        }
        else if (searchArgs.getStatus().equals("Display All"))
        {
             issuesList = dcIssues.findAll();
        }
        else {

            issuesList = dcIssues.findAllIssuesByBugStatus(searchArgs.getStatus());
        }

        return issuesList;
    }

    /**
     *
     * @param issueId
     * @return DCIssuesEntity
     *
     * This method returns a singleton object which will be used to populate the update form
     */
    public DCIssuesEntity getIssueData(long issueId) {

        List<DCIssuesEntity> issuesList = dcIssues.findOneSingleIssue(issueId);


        DCIssuesEntity singleIssue = null;
        if (issuesList.size() == 1) {
            singleIssue = issuesList.get(0);
        }

        return singleIssue;
    }

    public List<DCIssuesEntity> filterData(List<DCIssuesEntity> inputList, AdminDisplayForm issuesForm) {

        final String id = issuesForm.getIssueId();
        final String provider = issuesForm.getProvider();
        final String payor = issuesForm.getPayor();
        final String practice = issuesForm.getPractice();
        final String parDocNo = issuesForm.getParentDocumentNumber();
        final String startDate = issuesForm.getStartDate();
        final String endDate = issuesForm.getEndDate();
        final String problemType = issuesForm.getProblemType();
        final String assignedTo = issuesForm.getAssignedTo();
        final String checkNum = issuesForm.getCheckNum();
        final String checkDate = issuesForm.getCheckDate();

        List<DCIssuesEntity> newList = inputList;


        if (!provider.equals(""))     {
            newList = filterOnProvider(inputList, newList, issuesForm.getProblemType());
        }
        if (!problemType.equals(" "))     {
            newList = filterOnProblemType(inputList, newList, issuesForm.getProblemType());
        }
        if (!assignedTo.equals(" "))     {
            newList = filterOnAssignedTo(inputList, newList, issuesForm.getAssignedTo());
        }
        if (!parDocNo.equals(""))     {
            newList = filterOnParDocNo(inputList, newList, issuesForm.getParentDocumentNumber());
        }
        if (!practice.equals(""))     {
            newList = filterOnPractice(inputList, newList, issuesForm.getPractice());
        }
        if (!payor.equals(""))     {
            newList = filterOnPayor(inputList, newList, issuesForm.getPayor());
        }
        if (!checkNum.equals(""))     {
            newList = filterOnCheckNum(inputList, newList, issuesForm.getCheckDate());
        }
        log.info("Start date = {}", startDate);
        if (!startDate.equals(""))     {
            newList = filterOnStartDate(inputList, newList, issuesForm.getStartDate());
        }
        if (!endDate.equals(""))     {
            newList = filterOnEndDate(inputList, newList, issuesForm.getEndDate());
        }

        addIssueCount(newList);

        return newList;
    }


    public List<DCIssuesEntity> filterOnProblemType(List<DCIssuesEntity> inputList, List<DCIssuesEntity> outputList, String problemType) {

            outputList = inputList.parallelStream()
                    .filter((x) -> problemType.equals(x.getProblemType()))
                    .collect(Collectors.toList());

        return outputList;
    }

    public List<DCIssuesEntity> filterOnAssignedTo(List<DCIssuesEntity> inputList, List<DCIssuesEntity> outputList, String assignedTo) {

        outputList = inputList.parallelStream()
                .filter((x) -> assignedTo.equals(x.getAssignedTo()))
                .collect(Collectors.toList());

        return outputList;
    }

    public List<DCIssuesEntity> filterOnParDocNo(List<DCIssuesEntity> inputList, List<DCIssuesEntity> outputList, String parDocNo) {

        outputList = inputList.parallelStream()
                .filter((x) -> parDocNo.equals(x.getPardocno()))
                .collect(Collectors.toList());

        return outputList;
    }

    public List<DCIssuesEntity> filterOnProvider(List<DCIssuesEntity> inputList, List<DCIssuesEntity> outputList, String provider) {

        outputList = inputList.parallelStream()
                .filter((x) -> provider.equals(x.getProviderId()))
                .collect(Collectors.toList());

        return outputList;
    }

    public List<DCIssuesEntity> filterOnPractice(List<DCIssuesEntity> inputList, List<DCIssuesEntity> outputList, String practice) {

        outputList = inputList.parallelStream()
                .filter((x) -> practice.equals(x.getPractice()))
                .collect(Collectors.toList());

        return outputList;
    }

    public List<DCIssuesEntity> filterOnPayor(List<DCIssuesEntity> inputList, List<DCIssuesEntity> outputList, String payor) {

        outputList = inputList.parallelStream()
                .filter((x) -> payor.equals(x .getExtpayor()))
                .collect(Collectors.toList());

        return outputList;
    }

    public List<DCIssuesEntity> filterOnCheckNum(List<DCIssuesEntity> inputList, List<DCIssuesEntity> outputList, String checkNum) {

        outputList = inputList.parallelStream()
                .filter((x) -> checkNum.equals(x.getChecknum()))
                .collect(Collectors.toList());

        return outputList;
    }

    public List<DCIssuesEntity> filterOnCheckDate(List<DCIssuesEntity> inputList, List<DCIssuesEntity> outputList, String checkDate) {

        outputList = inputList.parallelStream()
                .filter((x) -> checkDate.equals(x.getCheckDate()))
                .collect(Collectors.toList());

        return outputList;
    }

    public List<DCIssuesEntity> filterOnStartDate(List<DCIssuesEntity> inputList, List<DCIssuesEntity> outputList, String startDate) {

        SimpleDateFormat df = new SimpleDateFormat("mm/DD/yy");
        String bugStartStr = df.format(startDate);
        Timestamp bugStart = new Timestamp(Long.parseLong(bugStartStr));
        outputList = inputList.parallelStream()
                .filter((x) -> bugStart.after(x.getBugEnteredDate()))
                .collect(Collectors.toList());

        return outputList;
    }

    public List<DCIssuesEntity> filterOnEndDate(List<DCIssuesEntity> inputList, List<DCIssuesEntity> outputList, String endDate) {

        Timestamp bugEnd = new Timestamp(Long.parseLong(endDate));
        outputList = inputList.parallelStream()
                .filter((x) -> bugEnd.after(x.getBugFixedDate()))
                .collect(Collectors.toList());

        return outputList;
    }

    public List<DCIssuesEntity> filterOnStartAndEndDate(List<DCIssuesEntity> inputList, List<DCIssuesEntity> outputList,
                                   String startDate, String endDate) {

        Timestamp bugStart = new Timestamp(Long.parseLong(startDate));
        Timestamp bugEnd = new Timestamp(Long.parseLong(endDate));

        outputList = inputList.parallelStream()
                .filter((x) -> bugStart.after(x.getBugEnteredDate()) && bugEnd.before(x.getBugFixedDate()))
                .collect(Collectors.toList());

        return outputList;
    }

    public void addIssueCount(List<DCIssuesEntity> listIn) {

        long count = 1;
        for (DCIssuesEntity tmp : listIn) {
            tmp.setIssueCount(count++);
        }
    }
}
