package com.manhua.h5server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.tobato.fastdfs.FdfsClientConfig;

@SpringBootApplication
@EnableAutoConfiguration
@Import(FdfsClientConfig.class)
@EnableTransactionManagement // 添加事务支持
@ComponentScan(basePackages = { "com.manhua", "com.manhua.db" })
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		logger.info("系统启动...");

		SpringApplication.run(App.class, args);
	}
}
