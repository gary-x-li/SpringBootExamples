package demo.springboot;

import demo.pojo.MyBean;
import demo.springboot.logging.MyLogWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired @Qualifier("singletonBean")
    private MyBean mbs;

    @Autowired @Qualifier("prototypeBean")
    private MyBean mbp;

    @Autowired @Qualifier("prototypeBeanWithProxy")
    private MyBean mbpp;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //loggers();
        printAutowiredBeans();
        printBeans();
        printBeansWithArg();
    }

    private void loggers() {
        log.warn("SpringbootApplication starts");

        MyLogWriter writer = new MyLogWriter();
        writer.write();
    }

    private void printAutowiredBeans() {
        System.out.println("mbs: " + mbs.hashCode());
        mbs.sayHi();
        System.out.println("mbp: " + mbp.hashCode());
        mbp.sayHi();
        System.out.println("mbpp: " + mbpp.hashCode());
        mbpp.sayHi();
    }

    private void printBeans() {
        MyBean s1 = (MyBean)applicationContext.getBean("singletonBean");
        MyBean s2 = (MyBean)applicationContext.getBean("singletonBean");
        System.out.println("s1: " + s1.hashCode());
        System.out.println("s2: " + s2.hashCode());
        s1.sayHi();
        s2.sayHi();

        MyBean p1 = (MyBean)applicationContext.getBean("prototypeBean");
        MyBean p2 = (MyBean)applicationContext.getBean("prototypeBean");
        System.out.println("p1: " + p1.hashCode());
        System.out.println("p2: " + p2.hashCode());
        p1.sayHi();
        p2.sayHi();

        MyBean pp1 = (MyBean)applicationContext.getBean("prototypeBeanWithProxy");
        MyBean pp2 = (MyBean)applicationContext.getBean("prototypeBeanWithProxy");
        System.out.println("pp1: " + pp1.hashCode());
        System.out.println("pp2: " + pp2.hashCode());
        pp1.sayHi();
        pp2.sayHi();
    }

    private void printBeansWithArg() {
        MyBean pa1 = (MyBean) applicationContext.getBean("prototypeBeanWithArg", "pa1");
        MyBean pa2 = (MyBean) applicationContext.getBean("prototypeBeanWithArg", "pa2");
        System.out.println("pa1: " + pa1.hashCode());
        System.out.println("pa2: " + pa2.hashCode());
        pa1.sayHi();
        pa2.sayHi();
    }
}
