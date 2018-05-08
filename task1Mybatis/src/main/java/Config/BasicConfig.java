package Config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Administrator on 2018/5/7.
 */
@Configuration
@ComponentScan(basePackages = {"serviceImpl","Impl"})
public class BasicConfig {

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jt1?useUnicode=true&characterEncoding=utf-8");
        dataSource.setUsername("user3");
        dataSource.setPassword("Password3,");
        dataSource.setInitialSize(5);
        return dataSource;
    }
}
