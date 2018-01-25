package org.forten.scss.bo;

import org.forten.dao.HibernateDao;
import org.forten.scss.entity.SysParams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysParamsBo {
    @Resource
    private HibernateDao dao;

    @Transactional(readOnly = true)
    public List<SysParams> queryAll(){
        return dao.findAll(SysParams.class);
    }
}
