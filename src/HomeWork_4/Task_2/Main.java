package HomeWork_4.Task_2;

import java.util.Scanner;

/*
Задана последовательность, состоящая только из символов ‘>’,
‘<’ и ‘-‘. Требуется найти количество стрел, которые спрятаны в этой
последовательности. Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’.
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите последовательность состоящую из символов ‘>’, ‘<’ и ‘-‘ (без пробелов).");
        String s = sc.nextLine();

        int count = 0;
        for (int i = 0; i <= s.length() - 5; i++) {
            if (s.startsWith(">>-->", i)) {
                count++;
            } else if (s.startsWith("<--<<", i)) {
                count++;
            }
        }

        System.out.println("Искомое количество стрелок подстроки вида ‘>>-->’ и ‘<--<<’: " + count);
        sc.close();
    }
}
