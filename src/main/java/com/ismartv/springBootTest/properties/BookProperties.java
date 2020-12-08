package com.ismartv.springBootTest.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义配置
 * 读取配置文件 application.properties 中以book开头的属性
 */
@Component
//@Profile代表使用那个配置文件
@Profile("dev")
@ConfigurationProperties("book")
public class BookProperties {

    @Setter
    @Getter
    private Double price;
}
