package com.dobby.project.cart.dto;

import java.util.List;


public class DeleteDto {  //카트 ID List로 받아온것
    List<Integer> cartIdList;

    public List<Integer> getCartIdList() {
        return cartIdList;
    }

    public void setCartIdList(List<Integer> cartIdList) {

        this.cartIdList = cartIdList;
    }

    public DeleteDto() {}

    public DeleteDto(List<Integer> cartIdList) {
        this.cartIdList = cartIdList;
    }
}
