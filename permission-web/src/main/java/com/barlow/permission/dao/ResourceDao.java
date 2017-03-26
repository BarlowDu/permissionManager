package com.barlow.permission.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dtc on 2017/3/25.
 */
@Repository("resourceDao")
public class ResourceDao {
    @Resource(name="sessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    public List<com.barlow.permission.model.Resource> selectAll(){
        return sqlSessionTemplate.selectList("com.barlow.permission.dao.ResourceDao.selectAll");
    }
}
