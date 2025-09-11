package HomeWork_11Addition.repository;

import HomeWork_11Addition.model.Car;

import java.util.List;

public interface CarsRepository {
    List<Car> loadCarsFromFile(String filepath) throws Exception;
}
