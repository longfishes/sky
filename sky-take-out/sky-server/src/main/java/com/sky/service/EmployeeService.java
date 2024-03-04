package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.dto.PasswordEditDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     *
     * @param employeeLoginDTO 员工登录DTO
     * @return Employee
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 新增员工
     *
     * @param employeeDTO empDTO
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * 员工分页查询
     *
     * @param employeePageQueryDTO empDTO
     * @return page bean
     */
    PageResult<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 启用禁用员工账号
     *
     * @param status sta
     * @param id     id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 根据id查询员工
     *
     * @param id id
     * @return emp
     */
    Employee getById(Long id);

    /**
     * 编辑员工信息
     *
     * @param employeeDTO dto
     */
    void update(EmployeeDTO employeeDTO);

    /**
     * 员工修改密码
     *
     * @param passwordEditDTO dto
     */
    void editPassword(PasswordEditDTO passwordEditDTO);
}
