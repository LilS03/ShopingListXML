package com.example.shopinglistxml.presentation
import androidx.lifecycle.ViewModel
import com.example.shopinglistxml.data.ShopListRepositoryImpl
import com.example.shopinglistxml.domain.ChangeItemOnShopList
import com.example.shopinglistxml.domain.DeleteItemFromShopList
import com.example.shopinglistxml.domain.GetShopListUseCase
import com.example.shopinglistxml.domain.ShopItem

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteItemFromShopList(repository)
    private val changeShopItemUseCase = ChangeItemOnShopList(repository)
    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteItem(shopItem)
    }
    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        changeShopItemUseCase.changeItem(newItem)
    }
}