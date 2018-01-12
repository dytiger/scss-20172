package org.forten.scss.dto.qo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CourseQoForTeacher {
    private String name;
    private String status;
    private Date begin;
    private Date end;

    private int first;
    private int page;
    private int rows;

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

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "CourseQoForTeacher{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", first=" + first +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
