package com.mulinge.auth2;

import com.mulinge.auth2.config.RsaKeysConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeysConfig.class)
public class SpringAuth2ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuth2ResourceServerApplication.class, args);
	}

}
