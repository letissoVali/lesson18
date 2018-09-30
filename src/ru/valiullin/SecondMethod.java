package ru.valiullin;

import java.io.*;

public class SecondMethod {

    static String fileName = "file-V1.txt";

    public static void secondMethod() {
        String newText = "Some handsome text. Новый некий текст!";
        String newFileName = "newFile-V2.txt";
        //ver2
        try (OutputStream outs = new FileOutputStream(newFileName);
             InputStream ins = new FileInputStream(fileName)) {
            System.out.println("Размер копируемого файла: " + ins.available());
            //int bufferSize = plainText.length(); //Вопрос: почему нельзя использовать количество симоволов строки? В
            //файле поялвются кроказябры. Если использовать количество байт которое можно считать то все ок. А ну да, из-за кодировки?
            int bufferSize = ins.available();
            int bytes = 0;  //переменная для чтения байта
            byte[] buffer = new byte[bufferSize];
            while (bytes != -1) {
                bytes = ins.read(buffer);
                if (bytes != -1) {
                    buffer = new String(buffer).getBytes("Windows-1251");//Можно ли это действие расписать по другому?
                    //А если нужно добавить строку newText? нужно использовать append?
                    outs.write(buffer);
                }
                 /*System.out.print(Arrays.toString(buffer));
                 for (int i = 0; i < buffer.length; i++) {
                    System.out.print(buffer[i]);
                }*/
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
