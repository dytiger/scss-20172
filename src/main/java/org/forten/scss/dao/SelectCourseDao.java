package org.forten.scss.dao;

import org.apache.ibatis.annotations.Param;
import org.forten.scss.dto.vo.CourseVoForSelect;

import java.util.List;

public interface SelectCourseDao {
    List<CourseVoForSelect> queryForSelect(@Param("cadreId") long cadreId);
}
