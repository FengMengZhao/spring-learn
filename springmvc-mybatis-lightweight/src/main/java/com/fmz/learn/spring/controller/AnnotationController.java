package com.fmz.learn.spring.controller;

import com.fmz.learn.spring.mapper.GetDeptTree;
import com.fmz.learn.spring.pojo.DeptTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnnotationController {

    @Autowired
    GetDeptTree getDeptTree;

    @RequestMapping(value="/mybatisDemo", method=RequestMethod.GET)
    @ResponseBody
    public DeptTree mybatisDemo(){
        return getDeptTree.queryDeptTree();
    }

}
