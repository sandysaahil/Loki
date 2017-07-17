package com.javainuse;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.javainuse.controller.JobInvokerController;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		//SpringApplication.run(SpringBatchApplication.class, args);
		
		
		SpringApplication app = new SpringApplication(SpringBatchApplication.class);
	    app.setWebEnvironment(false);
		ConfigurableApplicationContext ctx = app.run(args);

		JobInvokerController jobInvokerController = ctx.getBean(JobInvokerController.class);
		jobInvokerController.handle();
		// ApplicationContext context = new
		// AnnotationConfigApplicationContext(BatchConfig.class);
		// JobInvokerController cont = (JobInvokerController)
		// context.getBean("jobInvokerController");
		// cont.handle();
	}
}
