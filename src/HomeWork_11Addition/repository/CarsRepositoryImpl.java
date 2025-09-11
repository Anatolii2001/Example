package HomeWork_11Addition.repository;

import HomeWork_11Addition.model.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CarsRepositoryImpl implements CarsRepository {

    @Override
    public List<Car> loadCarsFromFile(String filepath) throws Exception {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\\|");
                if (parts.length != 5) continue; // простая валидация
                Car car = new Car(
                        parts[0],
                        parts[1],
                        parts[2],
                        Long.parseLong(parts[3]),
                        Long.parseLong(parts[4])
                );
                cars.add(car);
            }
        }
        return cars;
    }
}
