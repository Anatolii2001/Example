package HomeWork_2;

import java.util.Random;

/*
Задача 2*. Вася и Петя играют в игру “Камень, ножницы, бумага”.
Каждый из них показывает свою фигуру камень-0, ножницы-1, бумага-2.
Программа определяет, кто из них выиграл.
Выбор каждого участника формируется случайным образом.
 */
class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int vasyaChoice = random.nextInt(3);
        int petyaChoice = random.nextInt(3);
        System.out.println("Вася выбрал: " + choiceToString(vasyaChoice));
        System.out.println("Петя выбрал: " + choiceToString(petyaChoice));
        if (vasyaChoice == petyaChoice) {
            System.out.println("Ничья!");
        } else if ((vasyaChoice == 0 && petyaChoice == 1) ||
                (vasyaChoice == 1 && petyaChoice == 2) ||
                (vasyaChoice == 2 && petyaChoice == 0)) {
            System.out.println("Вася выйграл!");
        } else {
            System.out.println("Петя выйграл!");
        }
    }

    private static String choiceToString(int choice) {
        return switch (choice) {
            case 0 -> "Камень";
            case 1 -> "Ножницы";
            case 2 -> "Бумага";
            default -> "Не известный выбор";
        };
    }
}
