package com.book.bookshop.entity;

import lombok.Data;

/**
 @author：ZhouYao
 @create：2022-01-20 17:34
 这里为购物车列表中的数据，即用户的购物车信息
 */

@Data
public class CartVo {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer count;
    private String bookName;
    private String imgUrl;
    private double newPrice;
}
