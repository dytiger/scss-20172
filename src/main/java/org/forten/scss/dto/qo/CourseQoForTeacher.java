package org.forten.scss.dto.qo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CourseQoForTeacher {
    private String name;
    private String status;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date begin;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end;

    private int first;
    private int pageNo;
    private int pageSize;

    public CourseQoForTeacher() {
        this.pageNo = 1;
        this.pageSize = 5;
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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "CourseQoForTeacher{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", first=" + first +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
