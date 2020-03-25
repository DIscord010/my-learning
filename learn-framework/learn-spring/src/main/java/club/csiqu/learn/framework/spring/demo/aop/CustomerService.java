package club.csiqu.learn.framework.spring.demo.aop;

public class CustomerService {

    private String name;

    private String url;

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    void printName() {
        System.out.println("Customer name : " + this.name);
    }

    void printUrl() {
        System.out.print("Customer url : " + this.url);
    }
}