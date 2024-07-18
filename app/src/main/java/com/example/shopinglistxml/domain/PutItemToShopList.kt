package com.example.shopinglistxml.domain

class PutItemToShopList(private val shopListRepository: ShopListRepository) {
    fun putItem(item: ShopItem){
        shopListRepository.putItem(item)
    }
}