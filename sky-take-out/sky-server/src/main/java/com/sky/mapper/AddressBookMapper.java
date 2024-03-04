package com.sky.mapper;

import com.sky.entity.AddressBook;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressBookMapper {

    /**
     * 条件查询
     *
     * @param addressBook address
     * @return res
     */
    List<AddressBook> list(AddressBook addressBook);

    /**
     * 新增
     *
     * @param addressBook address
     */
    void insert(AddressBook addressBook);

    /**
     * 根据id查询
     *
     * @param id id
     * @return res
     */
    @Select("select * from address_book where id = #{id}")
    AddressBook getById(Long id);

    /**
     * 根据id修改
     *
     * @param addressBook address
     */
    void update(AddressBook addressBook);

    /**
     * 根据 用户id修改 是否默认地址
     *
     * @param addressBook address
     */
    @Update("update address_book set is_default = #{isDefault} where user_id = #{userId}")
    void updateIsDefaultByUserId(AddressBook addressBook);

    /**
     * 根据id删除地址
     *
     * @param id id
     */
    @Delete("delete from address_book where id = #{id}")
    void deleteById(Long id);

}
