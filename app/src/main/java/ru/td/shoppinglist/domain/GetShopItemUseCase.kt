package ru.td.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository:ShopListRepository) {
    fun GetShopItem(shopItemId:Int):ShopItem {
       return   shopListRepository.GetShopItem(shopItemId)
    }
}