package com.book.bookshop.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 @author：ZhouYao
 @create：2022-01-16 21:47
 图书类型枚举类
 */
@Getter
public enum Category {
    SELECTED(1, "精选图书"),
    RECOMMEND(2, "推荐图书"),
    BARGAIN(3, "特价图书");

    Category(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @EnumValue // 标记数据库储存的值是code
    private final int code;
    private final String desc;
}
