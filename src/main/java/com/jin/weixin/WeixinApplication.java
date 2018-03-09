package com.jin.weixin;

import com.jin.weixin.init.ApplicationStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class WeixinApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(WeixinApplication.class);
		springApplication.addListeners(new ApplicationStartup());
		springApplication.run(args);

	}
}
