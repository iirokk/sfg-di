package guru.spring.sfgdi;

import guru.spring.sfgdi.controllers.*;
import guru.spring.sfgdi.examplebeans.PlaceholderDataSource;
import guru.spring.sfgdi.examplebeans.PlaceholderMQBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		PlaceholderDataSource dataSource = ctx.getBean(PlaceholderDataSource.class);
		System.out.println(dataSource.getUser());
		System.out.println(dataSource.getLocale());

		PlaceholderMQBroker mqBroker = ctx.getBean(PlaceholderMQBroker.class);
		System.out.println(mqBroker.getUrl());
	}

}
