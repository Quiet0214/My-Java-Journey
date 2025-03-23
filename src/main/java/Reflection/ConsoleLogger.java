package Reflection;

public class ConsoleLogger implements Logger{
    @Override
    public void log(String message) {
        String s = "[Console]:"+message;
        System.out.println(s);
    }
}
