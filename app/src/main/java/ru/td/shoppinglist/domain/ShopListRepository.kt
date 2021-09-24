package ru.td.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun AddShopItem(ShopItem:ShopItem)
    fun DeleteShopItem(ShopItem:ShopItem)
    fun EditShopItem(ShopItem:ShopItem)
    fun GetShopItem(ShopItemId:Int):ShopItem
    fun GetShopList(): LiveData<List<ShopItem>>



}