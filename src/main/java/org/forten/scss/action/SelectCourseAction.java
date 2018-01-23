package org.forten.scss.action;

import org.forten.scss.bo.SelectCourseBo;
import org.forten.scss.dto.vo.CourseVoForSelect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SelectCourseAction {
    @Resource
    private SelectCourseBo bo;

    @GetMapping("/sc/courseForSelectList")
    public List<CourseVoForSelect> listCourseForSelect(){
        // TODO 干部ID应该从安全上下文中获取
        long cadreId = 1;

        return bo.queryForSelect(cadreId);
    }

    @GetMapping("/sc/courseForCancelList")
    public List<CourseVoForSelect> listCourseForCancel(){
        // TODO 干部ID应该从安全上下文中获取
        long cadreId = 1;

        return bo.queryForCancel(cadreId);
    }

    @GetMapping("/sc/selectedCourse")
    public List<CourseVoForSelect> listSelectedCourse(){
        // TODO 干部ID应该从安全上下文中获取
        long cadreId = 1;

        return bo.querySelectedCourse(cadreId);
    }
}
