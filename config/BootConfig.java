package com.hz.boot01.config;

import com.hz.boot01.pojo.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class BootConfig {   //创建bean实例  别名为stu
    @Bean(name = "pro")
    public Provider getStudent() {
        Provider pro = new Provider();


        pro.setProName("zhangsan");
        return pro;
    }
}
