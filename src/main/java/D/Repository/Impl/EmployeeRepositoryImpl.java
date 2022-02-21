package D.Repository.Impl;

import D.Entities.Employee;
import D.Repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepositoryImpl() {
        employees=new ArrayList<>();
    }

    @Override
    public void create(Employee employee) {
try {
 employee.setId(employees.size()+1l);
 employees.add(employee);
}catch (NullPointerException e) {
}
    }

    @Override
    public Employee findById(Integer id) {
        return employees.stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);

    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void Update(Employee employee) {
        employees
                .stream()
                .filter(student1 -> Objects.equals(student1.getId(), employee.getId())).forEach(x->x=employee);

    }

    @Override
    public void Delete(Employee employee) {
employees.remove(employee);
    }
}
