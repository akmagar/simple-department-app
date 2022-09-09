package com.myspringbootproject.myspringbootproject.service;

import com.myspringbootproject.myspringbootproject.entity.Department;
import com.myspringbootproject.myspringbootproject.repository.DepartmentRepository;
import error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional <Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department department1 = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            department1.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getGetDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getGetDepartmentAddress())){
            department1.setGetDepartmentAddress(department.getGetDepartmentAddress());
        }

        if(Objects.nonNull(department.getGetDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getGetDepartmentCode())){
            department1.setGetDepartmentCode(department.getGetDepartmentCode());
        }

        return departmentRepository.save(department1);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
