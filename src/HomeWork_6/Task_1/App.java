package HomeWork_6.Task_1;

import java.util.*;
/*
Необходимо реализовать приложение, принимающее список
пользователей, продуктов и обрабатывающее покупку пользователя.
 */
class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        List<Person> persons = new ArrayList<>();

        // Считываем продукты
        System.out.println("Введите продукты (название и цена) в формате \"название цена\". Введите END для завершения:");

        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Пустая строка. Введите: название цена");
                continue;
            }
            if (line.equalsIgnoreCase("END")) break;

            String[] parts = line.split("\\s+");
            if (parts.length < 2) {
                System.out.println("Неверный формат. Введите: название цена");
                continue;
            }

            // Последний элемент - стоимость
            String priceStr = parts[parts.length - 1];
            // Наименование товара с пробелом - все элементы, кроме последнего
            String productName = String.join(" ", Arrays.copyOf(parts, parts.length - 1));

            if (productName.trim().isEmpty()) {
                System.out.println("Название продукта не может быть пустым");
                continue;
            }

            double productPrice;
            try {
                productPrice = Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                System.out.println("Цена должна быть числом");
                continue;
            }

            try {
                Product product = new Product(productName, productPrice);
                products.add(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Считываем покупателей
        System.out.println("Введите покупателей (имя и деньги) в формате \"имя деньги\". Введите END для завершения:");

        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Пустая строка. Введите: имя деньги");
                continue;
            }
            if (line.equalsIgnoreCase("END")) break;

            String[] parts = line.split("\\s+");
            if (parts.length < 2) {
                System.out.println("Неверный формат. Введите: имя деньги");
                continue;
            }

            // Последний элемент - деньги
            String moneyStr = parts[parts.length - 1];
            // Имя и отчество - все элементы, кроме последнего
            String personName = String.join(" ", Arrays.copyOf(parts, parts.length - 1));

            if (personName.trim().isEmpty()) {
                System.out.println("Имя не может быть пустым");
                continue;
            }

            double personMoney;
            try {
                personMoney = Double.parseDouble(moneyStr);
            } catch (NumberFormatException e) {
                System.out.println("Деньги должны быть числом");
                continue;
            }

            try {
                Person person = new Person(personName, personMoney);
                persons.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Для каждого покупателя предлагаем выбирать продукты
        for (Person person : persons) {
            System.out.println("Покупатель " + person.getName() + ", выбирайте продукты (введите название продукта или END для завершения):");

            while (true) {
                String productName = scanner.nextLine().trim();
                if (productName.equalsIgnoreCase("END")) break;

                // Ищем продукт по названию
                Optional<Product> productOpt = products.stream()
                        .filter(p -> p.getName().equalsIgnoreCase(productName))
                        .findFirst();

                if (productOpt.isEmpty()) {
                    System.out.println("Продукт с названием \"" + productName + "\" не найден");
                    continue;
                }

                Product product = productOpt.get();

                if (person.buyProduct(product)) {
                    System.out.println(person.getName() + " купил " + product.getName());
                } else {
                    System.out.println(person.getName() + " не может позволить себе " + product.getName());
                }
            }
        }

        System.out.println("\nРезультаты покупок:");
        for (Person person : persons) {
            System.out.println(person);
        }

        scanner.close();
    }
}
