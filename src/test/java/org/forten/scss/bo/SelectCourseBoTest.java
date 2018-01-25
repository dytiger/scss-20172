package org.forten.scss.bo;

import org.forten.BaseTest;
import org.forten.dto.Message;
import org.forten.scss.dto.qo.CreditQoForCount;
import org.forten.scss.dto.vo.CourseVoForSelect;
import org.forten.scss.dto.vo.CreditVo;
import org.forten.scss.dto.vo.SelectInfoVoForWrite;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

public class SelectCourseBoTest extends BaseTest{
    @Resource
    private SelectCourseBo bo;

    @Test
    public void testQueryForSelect(){
        List<CourseVoForSelect> list = bo.queryForSelect(1);
        assertNotNull(list);
        assertEquals(5,list.size());

        list.forEach(System.out::println);

        list = bo.queryForSelect(2);
        assertNotNull(list);
        assertEquals(7,list.size());

        list.forEach(System.out::println);
    }

    @Test
    public void testQueryForCancel(){
        List<CourseVoForSelect> list = bo.queryForCancel(1);

        list.forEach(System.out::println);
    }

    @Test
    public void testQueryCreditForCount(){
        Message m = bo.queryCreditForCount(1);
        assertNotNull(m);
        System.out.println(m.getMessageText());
    }

    @Test
    public void testDoSelectCourse(){
        SelectInfoVoForWrite vo = new SelectInfoVoForWrite(1,20,"XK");
        Message m = bo.doSelectCourse(vo);

        assertNotNull(m);
        assertEquals("info",m.getTypeDes());

        vo = new SelectInfoVoForWrite(1,20,"PD");
        m = bo.doSelectCourse(vo);
    }
}