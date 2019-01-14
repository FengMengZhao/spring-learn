package com.fmz.learn.spring.pojo;

import java.util.List;

public class DeptTree {
    private String id;
    private String name;
    private List<DeptTree> childrenList;//子节点

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DeptTree> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<DeptTree> childrenList) {
        this.childrenList = childrenList;
    }

}
