package com.example.shopinglistxml.domain

class ChangeItemOnShopList(private val shopListRepository: ShopListRepository) {
    fun changeItem(shopItem: ShopItem){
        shopListRepository.changeItem(shopItem)
    }
}