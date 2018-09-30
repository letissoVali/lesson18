package ru.valiullin;

import java.io.*;
import java.util.Arrays;

public class PurgePhoneNum {
    private static String[] phoneRows =
            {"Sero","89871742187","Nero","89871454871","Dero","89872156988","Fero","89872365987","Wer","89872154879","Per","89872132655","Mero","89878221543"} ;

    public static void main(String[] args) {
        createPhoneNumbs(phoneRows,"PhoneNumbs.txt");
        String[] newPhoneRows = new String[phoneRows.length];
        try(BufferedReader reader = new BufferedReader(new FileReader("PhoneNumbs.txt"))) { //Почему нельзя
            // сделать в одном блоке try with resources BufferedWriter writer = new BufferedWriter(new FileWriter("PhoneNumbs.txt"))
            int i = 0;
            while (reader.ready()) {
                String line = reader.readLine();
                String[] phoneLineItem = line.split(" ");
                System.out.println(line);
                String line2 = phoneLineItem[1].replaceAll("(\\d{6}$)","******");
                //System.out.println(line2);
                if(newPhoneRows.length > i) {
                    newPhoneRows[i] = phoneLineItem[0];
                    newPhoneRows[i+1] = line2;
                }
                i= i + 2;
            }
            System.out.println(Arrays.toString(newPhoneRows));
        } catch (IOException e) {
            e.printStackTrace();
        }

        createPhoneNumbs(newPhoneRows, "PhoneNumbs.txt");
    }

    //Создаем телефонные номера

    /**
     * Метод для чего то, пока не придумал
     * @param strArr - принимает массив строк
     * @param fileName - принимает название файла
     */
    private static void createPhoneNumbs(String[] strArr, String fileName){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (int i = 0; i < strArr.length; i = i + 2) {
                writer.write(strArr[i]);
                writer.write(" ");
                writer.write(strArr[i+1]);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
