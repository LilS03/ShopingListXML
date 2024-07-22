package com.example.shopinglistxml.presentation
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.shopinglistxml.R

class ShopItemActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)
        val mode = intent.getStringExtra(extraScreenMode)
        Log.d("ShopItemActivity", mode.toString())
    }
    companion object{
        private const val extraScreenMode = "extra_mode"
        private const val extraShopItemID = "extra_shop_item_id"
        private const val modeEdit = "mode_edit"
        private const val modeAdd = "mode_add"
        fun newIntentAddItem(context: Context) : Intent{
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(extraScreenMode, modeAdd)
            return intent
        }
        fun newIntentEditItem(context: Context, shopItemId: Int) : Intent{
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(extraScreenMode, modeEdit)
            intent.putExtra(extraShopItemID, shopItemId)
            return intent
        }
    }
}