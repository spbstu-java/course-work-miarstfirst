package Lab3;

import Lab3.Dictionary.Dictionary;

import java.util.Objects;
import java.util.Scanner;



public class Main3 {
    public static void main(String[] args) {

        Dictionary d1 = new Dictionary("C:\\Users\\mihas\\OneDrive\\Рабочий стол\\S\\3к1с\\ООП Java\\CourseWork\\src\\Lab3\\resources\\d1.txt");

        System.out.println("Введите текст:");

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        System.out.println(
                Objects.equals(line, "") ?
                        "Ничего не введено!" :
                        "Перевод: " + d1.translate(line)
        );

    }
}





//
//public class Main3 {
//    public static void main(String[] args) {
//
//        String currentDirectory = System.getProperty("user.dir");
//        System.out.println("Текущая директория: " + currentDirectory);
//
//        Dictionary d1 = new Dictionary("C:\\Users\\mihas\\OneDrive\\Рабочий стол\\S\\3к1с\\ООП Java\\CourseWork\\src\\Lab3\\resources\\d1.txt");
////        new Dictionary("src/resources/d2.doc"); // упадет с исключением InvalidFileFormatException
//
//        System.out.println("Введите текст:");
//
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//
//        System.out.println(
//                Objects.equals(line, "") ?
//                    "Ничего не введено!" :
//                    "Перевод: " + d1.translate(line)
//            );
//
//    }
//}
