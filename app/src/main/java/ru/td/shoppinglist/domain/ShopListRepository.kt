package ru.td.shoppinglist.domain

interface ShopListRepository {

    fun AddShopItem(ShopItem:ShopItem)
    fun DeleteShopItem(ShopItem:ShopItem)
    fun EditShopItem(ShopItem:ShopItem)
    fun GetShopItem(ShopItemId:Int):ShopItem
    fun GetShopList(): List<ShopItem>



}