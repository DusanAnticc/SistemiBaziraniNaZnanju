package sbnz.integracija.example;

import java.util.Arrays;

import org.drools.core.ClockType;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan("sbnz.integracija.example")
@EnableJpaRepositories("sbnz.integracija.example")
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages = { "sbnz.integracija.example.*" })
@SpringBootApplication
public class SampleApp {

	private static Logger log = LoggerFactory.getLogger(SampleApp.class);

	public static void main(String[] args) {
//		ApplicationContext ctx = SpringApplication.run(SampleApp.class, args);
//
//		String[] beanNames = ctx.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//
//		StringBuilder sb = new StringBuilder("Application beans:\n");
//		for (String beanName : beanNames) {
//			sb.append(beanName + "\n");
//		}
//		log.info(sb.toString());
		SpringApplication.run(SampleApp.class, args);
	}
	
//	@Bean
//	public KieSession kieContainer() {
//		KieServices ks = KieServices.Factory.get();
//		KieContainer kContainer = ks
//				.newKieContainer(ks.newReleaseId("sbnz.integracija", "drools-spring-kjar", "0.0.1-SNAPSHOT"));
//		KieBaseConfiguration kieBaseConfiguration = ks.newKieBaseConfiguration();
//		kieBaseConfiguration.setOption(EventProcessingOption.STREAM);
//		KieBase kieBase = kContainer.newKieBase(kieBaseConfiguration);
//
//		KieSessionConfiguration kieSessionConfiguration = ks.newKieSessionConfiguration();
//		kieSessionConfiguration.setOption(ClockTypeOption.get(ClockType.REALTIME_CLOCK.getId()));
//		return kieBase.newKieSession(kieSessionConfiguration, null);
//	}
//	
	
	@Bean
	public KieContainer kieContainer() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks
				.newKieContainer(ks.newReleaseId("sbnz.integracija", "drools-spring-kjar", "0.0.1-SNAPSHOT"));
		KieScanner kScanner = ks.newKieScanner(kContainer);
		kScanner.start(10_000);
		return kContainer;
	}
	
	/*----------------------------------
	 * KieServices ks = KieServices.Factory.get(); KieContainer kContainer =
	 * ks.newKieContainer(ks.newReleaseId("drools-spring-v2",
	 * "drools-spring-v2-kjar", "0.0.1-SNAPSHOT")); KieScanner kScanner =
	 * ks.newKieScanner(kContainer); kScanner.start(10_000); KieSession kSession =
	 * kContainer.newKieSession();
	 */
}
