package com.example.shopinglistxml.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.shopinglistxml.domain.ShopItem

class ShopItemDIffCallBack: DiffUtil.ItemCallback<ShopItem>() {
    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }
}