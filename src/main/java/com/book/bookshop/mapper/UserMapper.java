package com.book.bookshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.bookshop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 @author：ZhouYao
 @create：2022-01-17 16:07
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
