package demo.springboot.beanscope;

import demo.pojo.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class ScopeConfig {

    @Bean
    public MyBean singletonBean() {
        return new MyBean("singleton");
    }

    @Bean
    @Scope("prototype")
    public MyBean prototypeBean() {
        return new MyBean("prototype");
    }

    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public MyBean prototypeBeanWithProxy() {
        return new MyBean("prototype_proxy");
    }

    @Bean
    @Scope("prototype")
    public MyBean prototypeBeanWithArg(String name) {
        return new MyBean(name);
    }

}
