package id.co.astrafinancial.app.repo;

import id.co.astrafinancial.app.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    // Empty interface.
}
