package com.rti.bugtracker.bizlogic;

import com.rti.bugtracker.domain.*;
import com.rti.dcbugs.domain.CategoryData;
import com.rti.dcbugs.domain.DCIssuesEntity;
import com.rti.dcbugs.domain.UserData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${dbutils.server}")
    private String dbutilsServer;

    @Value("${dbutils.port}")
    private String dbutilsPort;

    public DBUtils(DCCategory dcCategory, DCDeveloperNames dcDeveloperNames, DCIssues dcIssues) {

        this.dcCategory = dcCategory;
        this.dcDeveloperNames = dcDeveloperNames;
        this.dcIssues = dcIssues;
    }


    public List<String> getProblemTypes() {

        miscData = issuesTemplate.getForEntity("http://" + dbutilsServer + ":" + dbutilsPort + "/issues/problemtype",
                String[].class);
        //log.info("Value of miscData{}", miscData.getBody());
        List<DCCategoriesEntity>
        String[] problems = miscData.getBody();
        List<String> problemList = new ArrayList<>();
        for (String probStr : problems) {
            problemList.add(probStr);
        }

        return problemList;

    }

    public List<DCCategoriesEntity> getResolutionTypes() {




        List<CategoryData> resolutions = ;
        for (CategoryData resolution : resolutionList) {
            resolutions.add(resolution);
        }

        return resolutions;

    }


    public List<String> getAssignedUsers() {

        miscData = issuesTemplate.getForEntity("http://" + dbutilsServer + ":" + dbutilsPort + "/issues/assignedusers",
                String[].class);
        String[] users = miscData.getBody();
        List<String> userList = new ArrayList<>();
        for (String userName : users) {
            userList.add(userName);
        }

        return userList;

    }

    public List<UserData> getUsers() {

        userData = issuesTemplate.getForEntity("http://" + dbutilsServer + ":" + dbutilsPort + "/issues/developers",
                UserData[].class);
        UserData[] users = userData.getBody();
        List<UserData> userList = new ArrayList<>();
        for (UserData tmp : users) {
            userList.add(tmp);
        }

        return userList;

    }


    public void updateIssue(DCIssuesEntity issue) {

        Map<String, String> map = new HashMap<String, String>();
        String issueId = String.valueOf(issue.getBugId());
        map.put("issueId", issueId);

        dcIssues.save(issue);

    }


    public List<DCIssuesEntity> getIssuesData(AdminDisplayForm searchArgs) {

        if (!searchArgs.getIssueId().equals("All")) {
            //issuesData = issuesTemplate.getForEntity("http://" + dbutilsServer + ":"
            //        + dbutilsPort + "/issues/" + searchArgs.getIssueId(), DCIssuesEntity[].class);


        }
        else if (searchArgs.getStatus().equals("Display All"))
        {
            issuesData = issuesTemplate.getForEntity("http://" + dbutilsServer + ":"
                    + dbutilsPort + "/issues/allIssues", DCIssuesEntity[].class);
        }
        else {

            issuesData = issuesTemplate.getForEntity("http://" + dbutilsServer + ":"
                    + dbutilsPort + "/issues/bystatus/" + searchArgs.getStatus(), DCIssuesEntity[].class);
        }

        DCIssuesEntity[] issuesList = issuesData.getBody();

        List<DCIssuesEntity> dcIssuesList = new ArrayList<DCIssuesEntity>();
        for (DCIssuesEntity tmp : issuesList) {
            dcIssuesList.add(tmp);
        }

        /*
        if (dcIssuesList.size() > 1) {
            return dcIssuesList.parallelStream().filter(Objects::nonNull)
                    .sorted((DCIssuesEntity e1, DCIssuesEntity e2) -> (int) e1.getBugId() - ((int) e2.getBugId()))
                    .collect(Collectors.toList());
        }
        */
        return dcIssuesList;
    }

    /**
     *
     * @param issueId
     * @return DCIssuesEntity
     *
     * This method returns a singleton object which will be used to populate the update form
     */
    public DCIssuesEntity getIssueData(long issueId) {

        issuesData = issuesTemplate.getForEntity("http://" + dbutilsServer + ":"
                + dbutilsPort + "/issues/" + issueId, DCIssuesEntity[].class);

        DCIssuesEntity[] issuesList = issuesData.getBody();
        DCIssuesEntity singleIssue = null;
        if (issuesList.length == 1) {
            singleIssue = issuesList[0];
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
        IssueCount count = new IssueCount();
        count.incrementIssueCount();
        for (DCIssuesEntity tmp : listIn) {
            count.incrementIssueCount();
        }
    }
}
