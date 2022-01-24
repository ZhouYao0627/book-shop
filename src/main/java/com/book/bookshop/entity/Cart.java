package com.book.bookshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 @author：ZhouYao
 @create：2022-01-20 15:57
 */

@Data
@TableName(value = "bs_cart")
public class Cart extends Model<Cart> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer count; // 书的数量

    // 屏蔽book熟悉和数据库表中字段映射
    @TableField(exist = false)
    private Book book;
}
