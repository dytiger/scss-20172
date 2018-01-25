package org.forten.scss.bo;

import org.forten.BaseTest;
import org.forten.scss.entity.SysParams;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

public class SysParamsBoTest extends BaseTest {
    @Resource
    private SysParamsBo bo;

    @Test
    public void testQueryAll(){
        List<SysParams> list = bo.queryAll();

        list.forEach(System.out::println);
        System.out.println("-------------------------------");
        list = bo.queryAll();
        list.forEach(System.out::println);
    }
}