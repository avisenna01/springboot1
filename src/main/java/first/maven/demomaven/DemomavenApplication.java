package first.maven.demomaven;

import first.maven.demomaven.config.RsaKeyProperties;
import first.maven.demomaven.event.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class DemomavenApplication {

	private static final Logger log = LoggerFactory.getLogger(DemomavenApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemomavenApplication.class, args);

		log.info("Application running!");

		var helloWorld = new HelloWorld();
		System.out.println(helloWorld.sayHelloWorld());
	}

//	@BeanB
//	CommandLineRunner runner(
//	) {
//		return args -> {
//			Event event = new Event(1,"Konser A",
//					LocalDateTime.now(),LocalDateTime.now().plusHours(5),
//					1000, Location.JAKARTA);
//			log.info("Event: " + event);
//		};
//	}

}
