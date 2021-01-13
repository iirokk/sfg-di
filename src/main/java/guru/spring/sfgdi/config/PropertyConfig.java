package guru.spring.sfgdi.config;

import guru.spring.sfgdi.examplebeans.PlaceholderDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    @Autowired
    Environment environment;

    @Value("${guru.username}")
    String user;
    @Value("${guru.password}")
    String password;
    @Value("${guru.dburl}")
    String dburl;

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
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return placeholderConfigurer;
    }
}