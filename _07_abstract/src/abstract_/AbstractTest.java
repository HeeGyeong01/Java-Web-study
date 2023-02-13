package abstract_;

public abstract class AbstractTest { //POJO(Plain Old Java Object) 형식
    private String name;

    public AbstractTest() {}

    public AbstractTest(String name) {
        //super();
        this.name = name;
    }
    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public abstract void setName(String name); //추상 메소드();
}
