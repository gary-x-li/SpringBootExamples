package demo.pojo;

public class MyBean {

    private String name;

    public MyBean(String name) {
        this.name = name;
    }

    public String sayHi() {
        System.out.println(this.hashCode());
        return "Hi, " + name;
    }
}
