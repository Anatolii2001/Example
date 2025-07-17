package HomeWork_1;

import java.util.Scanner;

/*
Задача 1. Составить программу вывода на экран в одну строку сообщения
«Привет, имя_пользователя», где «имя_пользователя» - это введёное в консоль
имя, для выполнения данного задания нужно использовать класс Scanner.
 */
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя");
        String name = scanner.nextLine();
        scanner.close();
        System.out.println("Привет, " + name);
    }
}
