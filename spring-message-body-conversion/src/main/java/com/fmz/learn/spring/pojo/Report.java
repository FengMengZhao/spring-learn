package com.fmz.learn.spring.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Report {
    @XmlElement
    private int id;
    @XmlElement
    private String reportName;
    private String content;

    public String getReportName() {
        return reportName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", reportName='" + reportName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
