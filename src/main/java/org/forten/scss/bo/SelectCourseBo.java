package org.forten.scss.bo;

import org.forten.dao.MybatisDao;
import org.forten.scss.dao.SelectCourseDao;
import org.forten.scss.dto.vo.CourseVoForSelect;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SelectCourseBo {
    @Resource
    private MybatisDao mybatisDao;

    @Transactional(readOnly = true)
    public List<CourseVoForSelect> queryForSelect(long cadreId){
        return getSelectCourseDao().queryForSelect(cadreId);
    }

    private SelectCourseDao getSelectCourseDao(){
        return mybatisDao.openSession().getMapper(SelectCourseDao.class);
    }
}
