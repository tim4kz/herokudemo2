package kz.kaznitu.lessons.repositories;

import kz.kaznitu.lessons.models.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {

}
