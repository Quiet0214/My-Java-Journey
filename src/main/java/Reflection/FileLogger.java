package Reflection;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileLogger implements Logger{
    @Override
    public void log(String message) throws IOException {
        FileOutputStream fos = new FileOutputStream("./file/reflection");
        String s = "[File]:"+message;
        fos.write(s.getBytes());
        fos.close();
    }
}
