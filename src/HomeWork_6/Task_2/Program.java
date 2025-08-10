package HomeWork_6.Task_2;

import java.util.Objects;

class Program {
    private final String name;
    private final double rating;
    private final int viewers;

    public Program(String name, double rating, int viewers) {
        this.name = name;
        this.rating = rating;
        this.viewers = viewers;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" + name + '\'' +
                ", рейтинг = " + rating +
                ", число зрителей = " + viewers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return Double.compare(rating, program.rating) == 0 && viewers == program.viewers && Objects.equals(name, program.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating, viewers);
    }
}
