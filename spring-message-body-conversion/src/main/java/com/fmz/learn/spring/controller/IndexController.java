package com.fmz.learn.spring.controller;

import com.fmz.learn.spring.pojo.Report;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("resources")
public class IndexController {

    @RequestMapping(value = "result",
            //produces = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE,
            //produces = MediaType.TEXT_PLAIN_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public Report index() {

        //return " {\"reportName\": \"dummy report name\", \"content\": \"dummy report content\"}";
        Report r = new Report();
        r.setId(1);
        r.setReportName("a");
        return r;
    }

    @RequestMapping(value = "result.xml",
            //produces = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE,
            //produces = MediaType.TEXT_PLAIN_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public Report indexXml() {

        //return " {\"reportName\": \"dummy report name\", \"content\": \"dummy report content\"}";
        Report r = new Report();
        r.setId(1);
        r.setReportName("a");
        return r;
    }

    @RequestMapping(value = "result.json",
            produces = MediaType.APPLICATION_JSON_VALUE,
            //produces = MediaType.APPLICATION_XML_VALUE,
            //produces = MediaType.TEXT_PLAIN_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public Report indexJson() {

        //return " {\"reportName\": \"dummy report name\", \"content\": \"dummy report content\"}";
        Report r = new Report();
        r.setId(1);
        r.setReportName("a");
        return r;
    }
}
