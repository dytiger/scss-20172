package org.forten.scss.bo;

import org.apache.ibatis.session.SqlSession;
import org.forten.dao.HibernateDao;
import org.forten.dao.MybatisDao;
import org.forten.dto.Message;
import org.forten.scss.dao.CourseDao;
import org.forten.scss.dto.qo.CourseQoForTeacher;
import org.forten.scss.dto.vo.CourseForTeacher;
import org.forten.scss.entity.Course;
import org.forten.utils.system.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("courseBo")
public class CourseBo {
    @Resource
    private HibernateDao dao;
    @Resource
    private MybatisDao mybatisDao;

    @Transactional
    public Message doSave(Course course) {
        // TODO 可以使用AOP技术进行以下代码的分离
        ValidateUtil.validateThrow(course);
        try {
            dao.save(course);
            return Message.info("课程保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.error("课程保存失败！");
        }
    }

    @Transactional(readOnly = true)
    public List<CourseForTeacher> queryBy(CourseQoForTeacher qo) {
        SqlSession session = mybatisDao.openSession();
        CourseDao courseDao = session.getMapper(CourseDao.class);
        return courseDao.queryForTeacher(qo);
    }
}
