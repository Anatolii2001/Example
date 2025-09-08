package HomeWork_7.Task_1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/*
Реализовать метод, который на вход принимает ArrayList<T>, а возвращает набор
уникальных элементов этого массива. Решить, используя коллекции
 */
class UniqueElements {
   // Метод для получения уникальных элементов
    public static <T> Set<T> getUniqueElements(ArrayList<T> list) {
        // Используем LinkedNashSet для сохранения порядка
        Set<T> uniqueSet = new LinkedHashSet<>(list);
        return uniqueSet;
    }

    // Пример использования
    static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("aple");
        input.add("banana");
        input.add("aple");
        input.add("cherry");
        input.add("banana");

        Set<String> unique = getUniqueElements(input);
        System.out.println("Уникальные элементы: " + unique);
    }
}
