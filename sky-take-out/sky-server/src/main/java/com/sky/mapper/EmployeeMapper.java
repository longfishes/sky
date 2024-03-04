package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     *
     * @param username 用户名
     * @return Employee
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 插入员工数据
     *
     * @param employee 员工实体类
     */
    @AutoFill(value = OperationType.INSERT)
    void insert(Employee employee);

    /**
     * 员工分页查询
     *
     * @param employeePageQueryDTO dto
     * @return page
     */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 根据主键动态修改属性
     *
     * @param employee emp
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Employee employee);

    /**
     * 根据id查询员工信息
     *
     * @param id id
     * @return emp
     */
    @Select("select * from sky_take_out.employee where id = #{id}")
    Employee getById(Long id);
}
