package ru.valiullin;

import java.io.*;
import java.nio.charset.Charset;

public class ThirdReader {
    public static void thirdMethod() {
        //Reader

        try (Reader reader = new InputStreamReader(new FileInputStream("file-V1.txt"), Charset.defaultCharset());
            InputStream is = new FileInputStream("file-V1.txt");
            Writer writer = new OutputStreamWriter(new FileOutputStream("FileWriter.txt"), Charset.forName("Windows-1251"))) {

            char[] buffer = new char[is.available()];
            int bytes;
            if ((reader.read(buffer)) != -1) {
                String stringBuffer = new String(buffer);
                System.out.println("Третий метод "+stringBuffer);
                writer.write(stringBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
