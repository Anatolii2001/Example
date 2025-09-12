package HomeWork_11;

import java.util.Arrays;
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
 */
public class Main {
    static void main(String[] args) {
        // Входные данные: список строк автомобилей
        List<String> carData = Arrays.asList(
                "a123me|Mercedes|White|0|8300000",
                "b873of|Volga|Black|0|673000",
                "w487mn|Lexus|Grey|76000|900000",
                "p987hj|Volga|Red|610|704340",
                "c987ss|Toyota|White|254000|761000",
                "o983op|Toyota|Black|698000|740000",
                "p146op|BMW|White|271000|850000",
                "u893ii|Toyota|Purple|210900|440000",
                "l097df|Toyota|Black|108000|780000",
                "y876wd|Toyota|Black|160000|1000000"
        );

        // Параметры для поиска
        String colorToFind = "Black";
        long mileageToFind = 0L;
        long n = 700_000L;
        long m = 800_000L;
        String modelToFind1 = "Toyota";
        String modelToFind2 = "Volvo";

        // Создание списка автомобилей
        List<Car> cars = carData.stream()
                .map(data -> {
                    String[] parts = data.split("\\|");
                    return new Car(parts[0], parts[1], parts[2], Long.parseLong(parts[3]), Long.parseLong(parts[4]));
                })
                .collect(Collectors.toList());

        // Вывод автомобилей в базе
        System.out.println("Автомобили в базе:");
        System.out.println("Number     Model      Color      Mileage    Cost");
        cars.forEach(System.out::println);

        // 1. Номера автомобилей по цвету или пробегу
        List<String> numbersByColorOrMileage = cars.stream()
                .filter(car -> car.getColor().equals(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.toList());
        System.out.println("\nНомера автомобилей по цвету или пробегу: " + String.join(" ", numbersByColorOrMileage));

        // 2. Количество уникальных автомобилей в ценовом диапазоне (интерпретируем как количество автомобилей, так как в примере "уникальные автомобили")
        long countInRange = cars.stream()
                .filter(car -> car.getCost() >= n && car.getCost() <= m)
                .count();
        System.out.println("Уникальные автомобили: " + countInRange + " шт.");

        // 3. Цвет автомобиля с минимальной стоимостью
        Optional<String> minCostColor = cars.stream()
                .min(Comparator.comparingLong(Car::getCost))
                .map(Car::getColor);
        minCostColor.ifPresent(color -> System.out.println("Цвет автомобиля с минимальной стоимостью: " + color));

        // 4. Средняя стоимость искомой модели (Toyota)
        double avgCostToyota = cars.stream()
                .filter(car -> car.getModel().equals(modelToFind1))
                .mapToLong(Car::getCost)
                .average()
                .orElse(0.0);
        System.out.println("Средняя стоимость модели " + modelToFind1 + ": " + String.format("%.2f", avgCostToyota));

        // Дополнительно для Volvo (как в примере)
        double avgCostVolvo = cars.stream()
                .filter(car -> car.getModel().equals(modelToFind2))
                .mapToLong(Car::getCost)
                .average()
                .orElse(0.0);
        System.out.println("Средняя стоимость модели " + modelToFind2 + ": " + String.format("%.2f", avgCostVolvo));
    }
}

class Car {
    private String number;
    private String model;
    private String color;
    private long mileage;
    private long cost;

    public Car(String number, String model, String color, long mileage, long cost) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s %-10d %-10d",
                number, model, color, mileage, cost);
    }
}

