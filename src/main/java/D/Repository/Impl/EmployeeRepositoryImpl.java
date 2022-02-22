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
    public Long create(Employee employee) {
try {
employee.setId(employees.size()+1l);
 employees.add(employee);
}catch (NullPointerException e) {
}
        return employee.getId();
    }

    @Override
    public Employee findById(Long id) {
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
                .filter(student1 -> Objects.equals(student1.getUsername(), employee.getUsername())).forEach(x->x=employee);

    }

    @Override
    public void Delete(Long id) {
        employees.remove(id);
        employees
                .stream()
                .filter(student1 -> Objects.equals(student1.getId(),id) && student1.getId()>id).forEach(x->x.setId(x.getId()-1));
    }
}
