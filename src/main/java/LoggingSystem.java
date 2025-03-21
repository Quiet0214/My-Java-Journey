import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;
/*
* 自定义日志系统
* 使用了Consumer的andThen的链式处理。
* 加深了对匿名类，函数式编程，lambda表达式，Consumer接口以及日志记录的理解。
* */
public class LoggingSystem {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("./file/consumer");
        String s = "你好！";
        fos.write(s.getBytes(StandardCharsets.UTF_8));
        Consumer<String> logToConsole = message -> System.out.println(message+"在控制台打印:"+s);
        Consumer<String> logToFile = message -> System.out.println(message+"写入文件:"+s);

        Logger logger = new Logger();
        logger.addLogHandler(logToConsole);
        logger.addLogHandler(logToFile);
        logger.log("INFO","测试*****");
    }
}

class Logger{
    Consumer<String> cs = message ->{};
    public void addLogHandler(Consumer<String> e){
        cs = cs.andThen(e);
    }

    public void log(String level,String message){
        String s = "[" +level + "]:"+message;
        cs.accept(s);
    }
}
