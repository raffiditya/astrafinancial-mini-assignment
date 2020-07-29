package id.co.astrafinancial.app.service;

import id.co.astrafinancial.app.model.Employee;
import id.co.astrafinancial.app.repo.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Page<Employee> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Employee findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found."));
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }
}
