package D.Service.Impl;

import D.Entities.Employee;
import D.Repository.Impl.EmployeeRepositoryImpl;
import D.Service.EmployeeService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepositoryImpl employeeRepository;

    public EmployeeServiceImpl() {
        employeeRepository=new EmployeeRepositoryImpl();
    }

    @Override
    public boolean login(Employee employee) {
      List<Employee> employees=  employeeRepository.findAll();
List<Employee> employees1=      employees.stream().filter(x-> Objects.equals(x.getUsername(), employee.getUsername()) && Objects.equals(x.getPassword(), employee.getPassword())).collect(Collectors.toList());
    if(employees1.size()>0){
        return true;
    }
      return false;
    }

    @Override
    public Integer create(Employee employee) {
        return null;
    }

    @Override
    public Employee findById(Integer id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public void Update(Employee employee) {

    }

    @Override
    public void Delete(Integer id) {

    }
}