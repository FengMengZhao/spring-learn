package com.fmz.learn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AnnotationController {

    @Autowired
    @Qualifier("jdbcTemplate-ds1")
    JdbcTemplate jdbcTemplateDs1;

    @Autowired
    @Qualifier("jdbcTemplate-ds2")
    JdbcTemplate jdbcTemplateDs2;

    @RequestMapping(value="/ds1", method=RequestMethod.GET)
    @ResponseBody
    public String ds1(){

        Map<String, Object> map = new HashMap<String, Object>();
        String query = "SELECT * FROM db_jcsz.t_ldjsc_right";
        try {
            map = jdbcTemplateDs1.queryForMap(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  map.toString();
    }

    @RequestMapping(value="/ds2", method=RequestMethod.GET)
    @ResponseBody
    public String ds2(){

        Map<String, Object> map = new HashMap<String, Object>();
        String query = "SELECT * FROM db_uim.t_aty_code limit 1";
        try {
            map = jdbcTemplateDs2.queryForMap(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  map.toString();
    }

}
