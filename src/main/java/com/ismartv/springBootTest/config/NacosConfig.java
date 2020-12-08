package com.ismartv.springBootTest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * nacos 配置下发
* @ClassName: NacosConfig 
* @Description:
* @date 2020年12月8日 下午2:56:44 
*
 */
@Component
public class NacosConfig {

	
	@Value("${user.username}")
	@Getter
	private String username;
	
	@Value("${user.password}")
	@Getter
	private String password;
}
