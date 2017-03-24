package com.barlow.permission.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by dutc on 2017/3/24.
 */

@Repository("userDao")
public class UserDao {
    @Resource(name="sessionTemplate")
    SqlSessionTemplate sqlSessionTemplate;

    public Object selectAll(){
       return sqlSessionTemplate.selectList("com.barlow.permission.dao.UserDao.selectAll");
    }
}
