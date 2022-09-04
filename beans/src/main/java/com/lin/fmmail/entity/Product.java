package com.lin.fmmail.entity;

import javax.persistence.Id;

public class Product {
    /**
     * 商品编号
     */
    @Id
    private Integer id;

    /**
     * 图片
     */
    private String picture;

    /**
     * 姓名
     */
    private String name;

    /**
     * 信息
     */
    private String msg;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 库存
     */
    private Integer quantity;

    /**
     * 同一件商品的数量
     */
    private Integer num;

    /**
     * 总价
     */
    private Integer totalprice;

    /**
     * 获取商品编号
     *
     * @return id - 商品编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品编号
     *
     * @param id 商品编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取图片
     *
     * @return picture - 图片
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 设置图片
     *
     * @param picture 图片
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取信息
     *
     * @return msg - 信息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置信息
     *
     * @param msg 信息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取库存
     *
     * @return quantity - 库存
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置库存
     *
     * @param quantity 库存
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取同一件商品的数量
     *
     * @return num - 同一件商品的数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置同一件商品的数量
     *
     * @param num 同一件商品的数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取总价
     *
     * @return totalprice - 总价
     */
    public Integer getTotalprice() {
        return totalprice;
    }

    /**
     * 设置总价
     *
     * @param totalprice 总价
     */
    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }
}