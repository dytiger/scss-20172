package org.forten.scss.bo;

import org.forten.BaseTest;
import org.forten.scss.dto.vo.CourseVoForSelect;
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
}