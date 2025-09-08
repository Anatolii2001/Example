package HomeWork_7.Task_2;

import java.util.Arrays;
import java.util.Scanner;

/*
С консоли на вход подается две строки s и t. Необходимо вывести true, если одна
строка является валидной анаграммой другой строки, и false – если это не так.
Анаграмма – это слово, или фраза, образованная путем перестановки букв другого
слова или фразы, обычно с использованием всех исходных букв ровно один раз.
Для проверки:
● Бейсбол – бобслей
● Героин – регион
● Клоака – околка
 */
class AnagramCheck {
    // Метод для проверки анаграммы
    public static boolean isAnagram(String s, String t) {
        // Удаляем пробелы, приводим к нижнему регистру и нормализуем строки
        s = s.replaceAll("\\s+","").toLowerCase();
        t = t.replaceAll("\\s+","").toLowerCase();

        // Если длины разные - сразу false
        if (s.length() != t.length()) {
            return false;
        }

        // Преобразуем строки в массивы символов
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        //Сортируем массивы
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        //Сравниваем отсортированные массивы
        return Arrays.equals(sChars,tChars);
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Считываем две строки
        System.out.println("Введите первую строку: ");
        String s = scanner.nextLine();
        System.out.println("Введите вторую строку: ");
        String t = scanner.nextLine();

        //Проверяем и выводим результат
        System.out.println("Одна строка является валидной анаграммой другой строки: " + isAnagram(s,t));
    }
}
