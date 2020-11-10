package com.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "qualification")
@XmlAccessorType(XmlAccessType.FIELD)
public class Qualification {

    private DegreeName degreeName;
    private String duration;
    private Integer startYear;

    public DegreeName getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(DegreeName degreeName) {
        this.degreeName = degreeName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }
}
