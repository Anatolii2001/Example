package HomeWork_6.Task_2;

import java.util.Objects;

class Channel {
    private final String title;
    private final int number;
    private final Program program;

    public Channel(String title, int number, Program program) {
        this.title = title;
        this.number = number;
        this.program = program;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return  "{" + "название = '" + title + '\'' +
                ", порядковый номер = " + number +
                ", программа = " + program +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return number == channel.number && Objects.equals(title, channel.title) && Objects.equals(program, channel.program);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, number, program);
    }
}