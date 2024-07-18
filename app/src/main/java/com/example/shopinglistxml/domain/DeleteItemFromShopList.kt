package com.example.shopinglistxml.domain

class DeleteItemFromShopList(private val shopListRepository: ShopListRepository) {
    fun deleteItem(shopItem: ShopItem){
        shopListRepository.deleteItem(shopItem)
    }
}