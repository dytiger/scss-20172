package org.forten.scss.dao;

import org.apache.ibatis.annotations.Param;
import org.forten.scss.dto.vo.CourseVoForSelect;
import org.forten.scss.dto.vo.SelectInfoVoForWrite;

import java.util.List;

public interface SelectCourseDao {
    List<CourseVoForSelect> queryForSelect(@Param("cadreId") long cadreId);
    List<CourseVoForSelect> queryForCancel(@Param("cadreId") long cadreId);
    List<CourseVoForSelect> querySelectedCourse(@Param("cadreId") long cadreId);
    void selectCourse(SelectInfoVoForWrite vo);
    void addOneCurrentAmount(@Param("courseId") long courseId);
}
