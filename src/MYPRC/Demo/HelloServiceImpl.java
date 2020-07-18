package MYPRC.Demo;



/**
 * @author Dongguabai
 * @date 2018/11/1 15:51
 */
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("HelloServiceImpl");
        return "你好，" + name;

    }
}

