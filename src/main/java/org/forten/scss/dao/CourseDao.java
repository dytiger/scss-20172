package org.forten.scss.dao;

import org.apache.ibatis.annotations.Param;
import org.forten.scss.dto.qo.CourseQoForTeacher;
import org.forten.scss.dto.vo.CourseForTeacher;

import java.util.Date;
import java.util.List;

public interface CourseDao {
    List<CourseForTeacher> queryForTeacher(CourseQoForTeacher qo);
}
