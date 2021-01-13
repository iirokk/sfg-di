package guru.spring.sfgdi.config;

import guru.spring.sfgdi.examplebeans.PlaceholderDataSource;
import guru.spring.sfgdi.examplebeans.PlaceholderMQBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration

public class PropertyConfig {

    @Autowired
    Environment environment;

    @Value("${guru.username}")
    String user;
    @Value("${guru.password}")
    String password;
    @Value("${guru.dburl}")
    String dburl;

    @Value("${guru.mq.username}")
    String mqUser;
    @Value("${guru.mq.password}")
    String mqPassword;
    @Value("${guru.mq.url}")
    String mqUrl;

    @Bean
    public PlaceholderDataSource placeholderDataSource() {
        PlaceholderDataSource dataSource = new PlaceholderDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDburl(dburl);
        dataSource.setLocale(environment.getProperty("LANG"));
        return dataSource;
    }

    @Bean
    public PlaceholderMQBroker placeholderMQBroker() {
        PlaceholderMQBroker placeholderMQBroker = new PlaceholderMQBroker();
        placeholderMQBroker.setUser(mqUser);
        placeholderMQBroker.setPassword(mqPassword);
        placeholderMQBroker.setUrl(mqUrl);
        return placeholderMQBroker;
    }
}