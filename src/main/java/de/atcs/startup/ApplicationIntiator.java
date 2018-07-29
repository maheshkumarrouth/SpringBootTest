package de.atcs.startup;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.atcs.jpa.manager.AirTrafficControlManager;

@SpringBootApplication(scanBasePackages = "de.atcs")
@EntityScan(basePackages="de.atcs.model")
@EnableJpaRepositories(basePackages="de.atcs")
@EnableAspectJAutoProxy
public class ApplicationIntiator {
	public static void main(String args[]) {
		ConfigurableApplicationContext context = SpringApplication.run(ApplicationIntiator.class, args);
		context.getBean(AirTrafficControlManager.class).bootTheApplication();
	}	

}
