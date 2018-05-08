package Config;

import Impl.SignUpMapperImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Administrator on 2018/5/7.
 */

@Configuration
@Import(BasicConfig.class)
@ImportResource("classpath:sqlSessionFactory.xml")
public class RootConfig {
}
