package com.sky.service;

import com.sky.entity.AddressBook;
import java.util.List;

public interface AddressBookService {

    /**
     * 条件查询
     *
     * @param addressBook address
     * @return list
     */
    List<AddressBook> list(AddressBook addressBook);

    /**
     * 新增地址
     *
     * @param addressBook address
     */
    void save(AddressBook addressBook);

    /**
     * 根据id查询
     *
     * @param id id
     * @return address
     */
    AddressBook getById(Long id);

    /**
     * 根据id修改地址
     *
     * @param addressBook address
     */
    void update(AddressBook addressBook);

    /**
     * 设置默认地址
     *
     * @param addressBook address
     */
    void setDefault(AddressBook addressBook);

    /**
     * 根据id删除地址
     *
     * @param id id
     */
    void deleteById(Long id);

}
