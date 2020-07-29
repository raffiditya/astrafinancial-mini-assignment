package id.co.astrafinancial.app.controller;

import id.co.astrafinancial.app.model.Employee;
import id.co.astrafinancial.app.service.EmployeeService;
import id.co.astrafinancial.lib.model.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Employee> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/{employeeId:[\\d]+}")
    public ApiResponse<Employee> findById(@PathVariable int employeeId) {
        return ApiResponse.apiOk(service.findById(employeeId));
    }

    @PostMapping
    public ApiResponse<Employee> add(@RequestBody @Valid Employee employee) {
        if (employee.getId() != null) {
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Use PUT to edit entity.");
        }

        return ApiResponse.response(HttpStatus.CREATED, service.save(employee));
    }

    @PutMapping("/{employeeId:[\\d]+}")
    public ApiResponse<Employee> edit(@PathVariable int employeeId, @RequestBody @Valid Employee employee) {
        employee.setId(employeeId);

        return ApiResponse.apiOk(service.save(employee));
    }
}
