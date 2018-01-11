package org.forten.scss.dto.qo;

import java.util.Date;

public class CourseQoForTeacher {
    private String name;
    private String status;
    private Date begin;
    private Date end;

    public CourseQoForTeacher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "CourseQoForTeacher{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                '}';
    }
}
