package org.forten.scss.action;

import org.forten.dto.Message;
import org.forten.scss.bo.CourseBo;
import org.forten.scss.entity.Course;
import org.forten.utils.common.StringUtil;
import org.forten.utils.system.ValidateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class CourseAction {
    @Resource
    private CourseBo bo;

    @PostMapping("/course")
    public @ResponseBody
    Message save(@RequestBody Course course) {
        try {
            return bo.doSave(course);
        }catch(ValidateException e){
            return Message.error(StringUtil.join(e.getMessages(), "<br>"));
        }
    }
}
