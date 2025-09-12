package HomeWork_11Addition.test;

import HomeWork_11Addition.model.Car;
import HomeWork_11Addition.repository.CarsRepository;
import HomeWork_11Addition.repository.CarsRepositoryImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
1. Реализовать класс Автомобиль. У класса есть поля, свойства и
методы.
Поля класса:
а) Номер автомобиля;
б) Модель;
в) Цвет;
г) Пробег;
д) Стоимость.
Обратить внимание на переопределение метода toString, на сеттеры и
геттеры, модификаторы доступа полей.
2. Проверить работу в классе Main, методе main.
3. Создать объект Java Collections со списком автомобилей.
4. Используя Java Stream API, вывести (можно сделать любые 2 пункта
из 4):
1) Номера всех автомобилей, имеющих заданный в переменной цвет
colorToFind или нулевой пробег mileageToFind.
2) Количество уникальных моделей в ценовом диапазоне от n до m тыс.
3) Вывести цвет автомобиля с минимальной стоимостью.
4) Среднюю стоимость искомой модели modelToFind

Дополнительно:
1. Реализовать ввод и вывод программы в файл *.txt.
2. Вынести методы работы с автомобилем в папку repository интерфейс
CarsRepository и его реализацию CarsRepositoryImpl.
 */
public class Main {
    static void main(String[] args) {
        String inputFile = "src/HomeWork_11Addition/data/cars.txt";
        String outputFile = "src/HomeWork_11Addition/data/output.txt";

        // Параметры поиска
        String colorToFind = "Black";
        long mileageToFind = 0L;
        long n = 700_000L;
        long m = 800_000L;
        String modelToFind1 = "Toyota";
        String modelToFind2 = "Volvo";

        CarsRepository repo = new CarsRepositoryImpl();

        try {
            List<Car> cars = repo.loadCarsFromFile(inputFile);

            StringBuilder output = new StringBuilder();

            output.append("Автомобили в базе:\n");
            output.append(String.format("%-10s %-10s %-10s %-10s %-10s\n",
                    "Number", "Model", "Color", "Mileage", "Cost"));
            cars.forEach(car -> output.append(car.toString()).append("\n"));

            // 1. Номера автомобилей по цвету или пробегу
            List<String> numbersByColorOrMileage = cars.stream()
                    .filter(car -> car.getColor().equalsIgnoreCase(colorToFind) || car.getMileage() == mileageToFind)
                    .map(Car::getNumber)
                    .collect(Collectors.toList());
            output.append("\nНомера автомобилей по цвету или пробегу: ")
                    .append(String.join(" ", numbersByColorOrMileage))
                    .append("\n");

            // 2. Количество уникальных автомобилей в ценовом диапазоне
            long countInRange = cars.stream()
                    .filter(car -> car.getCost() >= n && car.getCost() <= m)
                    .count();
            output.append("Уникальные автомобили: ").append(countInRange).append(" шт.\n");

            // 3. Цвет автомобиля с минимальной стоимостью
            Optional<String> minCostColor = cars.stream()
                    .min(Comparator.comparingLong(Car::getCost))
                    .map(Car::getColor);
            minCostColor.ifPresent(color -> output.append("Цвет автомобиля с минимальной стоимостью: ").append(color).append("\n"));

            // 4. Средняя стоимость искомой модели Toyota
            double avgCostToyota = cars.stream()
                    .filter(car -> car.getModel().equalsIgnoreCase(modelToFind1))
                    .mapToLong(Car::getCost)
                    .average()
                    .orElse(0.0);
            output.append(String.format("Средняя стоимость модели %s: %.2f\n", modelToFind1, avgCostToyota));

            // Средняя стоимость искомой модели Volvo
            double avgCostVolvo = cars.stream()
                    .filter(car -> car.getModel().equalsIgnoreCase(modelToFind2))
                    .mapToLong(Car::getCost)
                    .average()
                    .orElse(0.0);
            output.append(String.format("Средняя стоимость модели %s: %.2f\n", modelToFind2, avgCostVolvo));

            // Запись в файл
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                bw.write(output.toString());
            }

            // Вывод в консоль
            System.out.println(output.toString());

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
