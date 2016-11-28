package com.rti.bugtracker.service;

import com.rti.bugtracker.domain.SavedDCIssuesEntity;
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

    private DCIssuesController amrIssues;

    @Autowired
    public UIController(DCIssuesController amrIssues) {
        this.amrIssues = amrIssues;
    }

    public UIController() {}

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public  String index(Model model) {
        //Map<String,Object> model = new HashMap<String,Object>();
        List<SavedDCIssuesEntity> issues = new ArrayList<>();
        model.addAttribute("issues", amrIssues.showAllIssues());

        return "index.html";
    }
}
