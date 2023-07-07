package com.zzl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

//在配置文件中查找到servers1前缀的属性镜像读取
@ConfigurationProperties(prefix = "servers1")

//@EnableConfigurationProperties不能@Component并用，产生冲突
//@EnableConfigurationProperties({ServletConfig.class})
//替代了component的作用
//@Component
//受spring管控，第三方bean
@Data

@Validated
public class ServletConfig {
    @Max(value = 8888,message = "最大不能超过('_')")
    private int port;

    private String ipAddress;
//    private long timeout;


//常用计量单位的使用

    //服务器超时响应时间
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTime;

    //储存空间的大小
//    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}
