package com.example.shopinglistxml.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun putItem(item: ShopItem)
    fun getShopList() : LiveData<List<ShopItem>>
    fun getShopItem(shopItemId: Int): ShopItem
    fun deleteItem(shopItem: ShopItem)
    fun changeItem(shopItem: ShopItem)
}