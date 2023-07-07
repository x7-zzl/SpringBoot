package com.zzl;

import com.alibaba.druid.pool.DruidDataSource;
import com.zzl.config.ServletConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties({ServletConfig.class})
@SpringBootApplication
public class Springboot10ConfigurationApplication {

    @Bean
    //具体的做属性绑定的
    //可以为第三方bean绑定属性
    @ConfigurationProperties(prefix = "datasource")

    public DruidDataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();

//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot10ConfigurationApplication.class, args);
        ServletConfig bean = ctx.getBean(ServletConfig.class);
        System.out.println(bean);

        DruidDataSource bean1 = ctx.getBean(DruidDataSource.class);
        System.out.println(bean1.getDriverClassName());
//        System.out.println(bean1);
    }

}
