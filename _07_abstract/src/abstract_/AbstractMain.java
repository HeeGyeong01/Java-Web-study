package abstract_;

public class AbstractMain extends AbstractTest {

    @Override
    public void setName(String name){
        //this.name = name;
        //여기 실행됨.
    }


    public static void main(String[] args){
        AbstractTest at = new AbstractMain();
        at.setName("이희경");
        System.out.println(at.getName());


    }


}
