package HomeWork_7.Task_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Реализовать класс PowerfulSet, в котором должны быть следующие методы:
● public <T> Set<T> intersection(Set<T> set1, Set<T> set2) – возвращает
пересечение двух наборов.
Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {1, 2}
● public <T> Set<T> union(Set<T> set1, Set<T> set2) – возвращает
объединение двух наборов
Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {0, 1, 2, 3, 4}
● public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) –
возвращает элементы первого набора без тех, которые находятся также и
во втором наборе.
Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {3}
 */
class PowerfulSet {
    //Пересечение двух множеств
    public static <T> Set<T> intersection(Set<T> set1,Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    //Объединение двух множеств
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    //Разность множеств (элементы set1 без элементов set2)
    public static <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }

    //Пример использования
    static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(0, 1, 2, 4));

        System.out.println("Пересечение: " + intersection(set1,set2));
        System.out.println("Объединение: " + union(set1,set2));
        System.out.println("Разность (set1 - set2): " + relativeComplement(set1,set2));
    }
}
