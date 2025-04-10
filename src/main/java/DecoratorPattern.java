public class DecoratorPattern {
    public static void main(String[] args) {
        People boy =new Boy();
        boy = new DressupSimpleDecorator(boy);
        boy = new MakeupDecorator(boy);
        boy = new DressupGrandDecorator(boy);
        System.out.println(boy.getColor());
        System.out.println(boy.getFace());
        System.out.println(boy.getDressed());
    }
}

//可以进行装饰需要满足的接口
interface People{
    public String getFace();
    public String getColor();
    public String getDressed();
}
//装饰器基类
abstract class PeopleDecorator implements People{
    private People people;
    public PeopleDecorator(People people){
        this.people=people;
    }
    @Override
    public String getFace(){
        return people.getFace();
    }
    @Override
    public String getColor(){
        return people.getColor();
    }

    @Override
    public String getDressed(){
        return people.getDressed();
    }
}


//等待被装饰的类
class Boy implements People{
    String face;
    String color;
    String dress;

    @Override
    public String getFace() {
        return "ugly";
    }

    @Override
    public String getColor() {
        return "black";
    }

    @Override
    public String getDressed() {
        return "naked";
    }
}


class MakeupDecorator extends PeopleDecorator{
    public MakeupDecorator(People people) {
        super(people);
    }
    @Override
    public String getFace(){
        return "make ugly to pretty";
    }

    @Override
    public String getColor(){
        return "make black to white";
    }
}



class DressupSimpleDecorator extends PeopleDecorator{
    public DressupSimpleDecorator(People people) {
        super(people);
    }

    public String getDressed(){
        return "wearing simple cloth";
    }
}

class DressupGrandDecorator extends PeopleDecorator{

    public DressupGrandDecorator(People people) {
        super(people);
    }

    public String getDressed(){
        return "wearing grand cloth";
    }

}