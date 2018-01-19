package org.forten.scss.dao;

import org.forten.scss.dto.qo.CadreQo;
import org.forten.scss.dto.vo.CadreVo;

import java.util.List;

public interface CadreDao {
    long queryCount(CadreQo qo);
    List<CadreVo> queryBy(CadreQo qo);
    List<CadreVo> queryForExport(CadreQo qo);
}
