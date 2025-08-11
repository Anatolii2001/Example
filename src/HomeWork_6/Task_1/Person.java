package HomeWork_6.Task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person {
    private final String name;
    private final List<Product> products;
    private double money;

    public Person(String name, double money) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательным числом");
        }
        this.name = name;
        this.money = money;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Метод покупки продукта
    public boolean buyProduct(Product product) {
        if (product == null) return false;
        if (this.money >= product.getPrice()) {
            this.money -= product.getPrice();
            products.add(product);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(money, person.money) == 0 && Objects.equals(name, person.name) &&
                Objects.equals(products, person.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, products);
    }

    @Override
    public String toString() {
        if (products.isEmpty()) {
            return name + " - Ничего не куплено";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < products.size(); i++) {
                sb.append(products.get(i).getName());
                if (i < products.size() - 1) {
                    sb.append(", ");
                }
            }
            return name + " - " + sb;
        }
    }
}