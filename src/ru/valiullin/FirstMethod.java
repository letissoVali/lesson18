package ru.valiullin;

import java.io.*;
import java.nio.charset.Charset;
import static java.nio.charset.Charset.defaultCharset;

public class FirstMethod {
    static String plainText = "Some beautiful text. Некий текст!";
    static String fileName = "file-V1.txt";

    public static void firstMethod() {
        // ver 1 write
        try(OutputStream os = new FileOutputStream(fileName)) {
            os.write(plainText.getBytes(defaultCharset()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //show me
        try(InputStream is = new FileInputStream(fileName)) {
            int bytes;
            while ((bytes = is.read()) != -1){
                //System.out.print("|" + bytes);
                //System.out.print("|" +(char) bytes); //Как сделать что бы в выводе показывались русские буквы.
                //System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //ver1 read - copy
        try(InputStream is = new FileInputStream(fileName);
            OutputStream os = new FileOutputStream("newFile-v1.txt")) {
            int bytes;
            byte[] buffer = new byte[is.available()];
            if ((bytes = is.read(buffer)) != -1) {
                String stringBuffer = new String(buffer);
                //System.out.println(stringBuffer);
                buffer = stringBuffer.getBytes(Charset.forName("Windows-1251"));
                os.write(buffer);
                os.flush();
                //странные дела, с начало данные не хотели уходить в файл под нужно кодировкой.
                // Немного потыкался и в итоге получилсь, что если в stringBuffer не ставить кодировку "Windows-1251"
                // то все норм. Почему?
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
