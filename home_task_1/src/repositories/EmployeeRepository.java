package repositories;

import models.Employee;

import java.util.Optional;
import java.util.UUID;

public class EmployeeRepository {
    public Optional<Employee> findEmployeeById(UUID id){
        return Optional.empty();
    }
}
