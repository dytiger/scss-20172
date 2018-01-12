package org.forten.scss.bo;

import org.forten.BaseTest;
import org.forten.dto.Message;
import org.forten.dto.PagedRo;
import org.forten.scss.dto.qo.CourseQoForTeacher;
import org.forten.scss.dto.ro.PagedRoForEasyUI;
import org.forten.scss.dto.vo.CourseForTeacher;
import org.forten.scss.dto.vo.CourseUpdateForTeacher;
import org.forten.scss.entity.Course;
import org.forten.utils.common.DateUtil;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CourseBoTest extends BaseTest {
    @Resource
    private CourseBo bo;

    @Test
    public void testDoSave() {
        Course course = new Course();
        course.setName("论共产主义实现");
        course.setBeginSelectTime(DateUtil.getCommonTime(2017, 2, 1, 8, 0, 0));
        course.setEndSelectTime(DateUtil.getCommonTime(2017, 2, 10, 17, 0, 0));
        course.setBeginTeachTime(DateUtil.getCommonTime(2017, 2, 15, 10, 0, 0));
        course.setEndTeachTime(DateUtil.getCommonTime(2017, 2, 15, 12, 0, 0));
        course.setClassroom("主楼214");
        course.setCredit(5);
        course.setTeacher("钱小黄");
        course.setIntro("论共产主义实现吗？");
        course.setServiceTeacher("刘丰");
        course.setServiceTeacherTel("1332828889");
        course.setMaxAmount(55);

        Message m = bo.doSave(course);

        assertNotNull(m);
        assertEquals("info", m.getTypeDes());
    }

    @Test
    public void testDoUpdate(){
        CourseUpdateForTeacher course = new CourseUpdateForTeacher();
        course.setId(1);
        course.setName("new Course");
        course.setBeginSelectTime(DateUtil.getCommonTime(2018, 2, 1, 8, 0, 0));
        course.setEndSelectTime(DateUtil.getCommonTime(2018, 2, 10, 17, 0, 0));
        course.setBeginTeachTime(DateUtil.getCommonTime(2018, 2, 15, 10, 0, 0));
        course.setEndTeachTime(DateUtil.getCommonTime(2018, 2, 15, 12, 0, 0));
        course.setClassroom("主楼214");
        course.setCredit(5);
        course.setTeacher("钱小黄");
        course.setIntro("论共产主义实现吗？");
        course.setServiceTeacher("刘丰");
        course.setServiceTeacherTel("1332828889");
        course.setMaxAmount(1000);
        course.setStatus("AC");

        Message m = bo.doUpdate(course);

        assertEquals("info",m.getTypeDes());
        assertEquals("课程修改成功！",m.getMsg());
    }

    @Test
    public void testQueryForTeacher(){
        Date begin = DateUtil.getCommonTime(2018,1,1);
        Date end = DateUtil.getCommonTime(2018,12,1);
        CourseQoForTeacher qo = new CourseQoForTeacher();
        qo.setBegin(begin);
        qo.setEnd(end);
        qo.setPageNo(4);

        PagedRoForEasyUI<CourseForTeacher> ro = bo.queryBy(qo);
        assertEquals(false,ro.isEmptyData());
        assertEquals(4,ro.getRows().size());

        ro.getRows().forEach(System.out::println);

        qo.setName("no name");
        ro = bo.queryBy(qo);
        assertEquals(true,ro.isEmptyData());
        assertEquals(0,ro.getRows().size());
    }
}