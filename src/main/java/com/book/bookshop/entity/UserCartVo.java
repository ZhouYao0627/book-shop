package com.book.bookshop.entity;

import lombok.Data;

/**
 @author：ZhouYao
 @create：2022-01-20 21:54
 用户购物车信息展示对象
 即购物车页面右上方的商品类数与总价
 */

@Data
public class UserCartVo {
    private Integer num;
    private double totalPrice;
}

