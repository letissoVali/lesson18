import ru.valiullin.FirstMethod;
import ru.valiullin.SecondMethod;
import ru.valiullin.ThirdReader;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.Charset.defaultCharset;


public class Main {
    public static void main(String[] args) {
        // todo 1. Написать программу, которая копирует файл с одной кодировкой в файл с другой. //firstMethod and secondMethod and thirdMethod
        // todo 2. Написать программу, которая удаляет из некоторого текста номера сотовых телефонов. Для простоты все номера сотовых телефонов состоят из 11 цифр подряд.
        // После консультации все удалил, попозже написал все это
        FirstMethod.firstMethod(); //вариант 1
        SecondMethod.secondMethod(); //вариант 1 только чуть чуть по другому
        ThirdReader.thirdMethod(); //типа вариант 2
    }

}
