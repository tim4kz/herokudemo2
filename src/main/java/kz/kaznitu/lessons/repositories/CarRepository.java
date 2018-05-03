package kz.kaznitu.lessons.repositories;

import kz.kaznitu.lessons.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
