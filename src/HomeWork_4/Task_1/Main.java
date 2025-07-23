package HomeWork_4.Task_1;

import java.util.Scanner;

/*
Для введенной с клавиатуры буквы английского алфавита
нужно вывести слева стоящую букву на стандартной клавиатуре. При этом
клавиатура замкнута, т.е. справа от буквы «p» стоит буква «a», а слева от "а"
буква "р", также соседними считаются буквы «l» и буква «z», а буква «m» с
буквой «q».
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите букву английского алфавита");
        String letter = sc.next().toLowerCase();
        String[] alphabet = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f",
                "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].equals(letter)) {
                int leftIndex = (i - 1 + alphabet.length) % alphabet.length;
                System.out.println("Слева стоящая буква стандартной клавиатуры от заданной: " + alphabet[leftIndex]);
                return;
            }
        }
        System.out.println("Введенная буква не найдена в массиве клавиатуры.");
    }
}
