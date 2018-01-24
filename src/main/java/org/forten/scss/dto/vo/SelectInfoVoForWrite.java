package org.forten.scss.dto.vo;

public class SelectInfoVoForWrite {
    private long cadreId;
    private long courseId;
    private String optType;

    public SelectInfoVoForWrite() {
    }

    public SelectInfoVoForWrite(long cadreId, long courseId, String optType) {
        this.cadreId = cadreId;
        this.courseId = courseId;
        this.optType = optType;
    }

    public long getCadreId() {
        return cadreId;
    }

    public void setCadreId(long cadreId) {
        this.cadreId = cadreId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    @Override
    public String toString() {
        return "SelectInfoVoForWrite{" +
                "cadreId=" + cadreId +
                ", courseId=" + courseId +
                ", optType='" + optType + '\'' +
                '}';
    }
}
