package com.example.shopinglistxml.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopinglistxml.domain.ShopItem
import com.example.shopinglistxml.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {
    private val shopList = sortedSetOf<ShopItem>({o1, o2 -> o1.id.compareTo(o2.id)})
    private val shopListLiveData = MutableLiveData<List<ShopItem>>()
    private var autoIncrementIt = 0
    init{
        for(i in 0 until 1000){
            val item = ShopItem("Name $i", i, true)
            putItem(item)
        }
    }
    override fun putItem(item: ShopItem){
        if(item.id == ShopItem.UNDEFINED_ID){
            item.id = autoIncrementIt++
        }
        shopList.add(item)
        updateList()
    }
    override fun getShopList() : LiveData<List<ShopItem>> {
        return shopListLiveData
    }
    override fun getShopItem(shopItemId: Int): ShopItem{
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with $shopItemId not found")
    }
    override fun deleteItem(shopItem: ShopItem){
        shopList.remove(shopItem)
        updateList()
    }
    override fun changeItem(shopItem: ShopItem){
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        putItem(shopItem)
        updateList()
    }
    private fun updateList(){
        shopListLiveData.value = shopList.toList()
    }
}