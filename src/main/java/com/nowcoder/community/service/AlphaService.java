package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;
    public AlphaService() {
        System.out.println("实例化service");
    }

    @PostConstruct//构造器方法之后调用
    public void init(){
        System.out.println("alphaservice初始化");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁alphaservice");
    }
    public String find(){
        return alphaDao.select();
    }
}
