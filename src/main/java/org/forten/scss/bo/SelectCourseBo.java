package org.forten.scss.bo;

import com.microsoft.schemas.office.office.STInsetMode;
import org.forten.dao.HibernateDao;
import org.forten.dao.MybatisDao;
import org.forten.dto.Message;
import org.forten.scss.dao.SelectCourseDao;
import org.forten.scss.dto.qo.CreditQoForCount;
import org.forten.scss.dto.vo.CourseVoForSelect;
import org.forten.scss.dto.vo.CreditVo;
import org.forten.scss.dto.vo.SelectInfoVoForWrite;
import org.forten.scss.entity.SysParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SelectCourseBo {
    @Resource
    private MybatisDao mybatisDao;
    @Resource
    private HibernateDao dao;

    @Transactional(readOnly = true)
    public List<CourseVoForSelect> queryForSelect(long cadreId) {
        return getSelectCourseDao().queryForSelect(cadreId);
    }

    @Transactional(readOnly = true)
    public List<CourseVoForSelect> queryForCancel(long cadreId) {
        return getSelectCourseDao().queryForCancel(cadreId);
    }

    @Transactional(readOnly = true)
    public List<CourseVoForSelect> querySelectedCourse(long cadreId) {
        return getSelectCourseDao().querySelectedCourse(cadreId);
    }

    @Transactional
    public Message doSelectCourse(SelectInfoVoForWrite vo) {
        try {
            getSelectCourseDao().selectCourse(vo);
            if (vo.getOptType().equals("XK")) {
                getSelectCourseDao().addOneCurrentAmount(vo.getCourseId());
                return Message.info("选课操作成功!");
            } else if (vo.getOptType().equals("PD")) {
                return Message.info("此课程已达到选课人数上限，您目前处理排队状态!");
            } else {
                return Message.warn("未知操作！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Message.error("选课操作失败!");
        }
    }

    @Transactional
    public Message doCancelCourse(long cadreId, long courseId) {
        SelectCourseDao selectCourseDao = getSelectCourseDao();
        try {
            selectCourseDao.cancelCourse(cadreId, courseId);

            Long toXKCadreId = selectCourseDao.queryPD2XK(courseId);
            if (toXKCadreId == null) {
                selectCourseDao.subOneCurrentAmount(courseId);
            } else {
                SelectInfoVoForWrite vo = new SelectInfoVoForWrite(toXKCadreId, courseId, "XK");
                selectCourseDao.selectCourse(vo);
            }
            return Message.info("退课操作成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.error("退课操作失败!");
        }
    }

    @Transactional(readOnly = true)
    public Message queryCreditForCount(long cadreId) {
        int minCredit = dao.loadById(SysParams.class, "MIN_CREDIT").getIntValue();
        int maxCredit = dao.loadById(SysParams.class, "MAX_CREDIT").getIntValue();
        String beginDate = dao.loadById(SysParams.class, "COUNT_BEGIN_DATE").getValue();
        String endDate = dao.loadById(SysParams.class, "COUNT_END_DATE").getValue();
        Date begin = dao.loadById(SysParams.class, "COUNT_BEGIN_DATE").getTimeValue();
        Date end = dao.loadById(SysParams.class, "COUNT_END_DATE").getTimeValue();

        CreditQoForCount qo = new CreditQoForCount();
        qo.setBegin(begin);
        qo.setEnd(end);
        qo.setCadreId(cadreId);

        Integer c = getSelectCourseDao().queryCreditForCount(qo);
        if (c == null) {
            c = 0;
        }

        String msg = "目前已经学习课程的学分总数为：" + c + "<br>在" + beginDate + "至" + endDate + "时间段内，您应该修习的学分为[" + minCredit + "~" + maxCredit + "]";
        return Message.info(msg);
    }

    private SelectCourseDao getSelectCourseDao() {
        return mybatisDao.openSession().getMapper(SelectCourseDao.class);
    }
}
