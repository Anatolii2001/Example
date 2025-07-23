package HomeWork_4.Task_3;

import java.util.Arrays;
import java.util.Scanner;

/*
Задана строка, состоящая из букв английского алфавита,
разделенных одним пробелом. Необходимо каждую последовательность
символов упорядочить по возрастанию и вывести слова в нижнем регистре.
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите последовательность символов представляющие два слова:");
        String input = sc.nextLine();

        String[] words = input.split(" ");

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            char[] chars = word.toLowerCase().toCharArray();
            Arrays.sort(chars);
            result.append(new String(chars)).append(" ");
        }

        System.out.println("Упорядоченные по возрастанию буквы в нижнем регистре: " + result.toString().trim());
        sc.close();
    }
}
