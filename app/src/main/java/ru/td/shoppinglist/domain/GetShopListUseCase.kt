package ru.td.shoppinglist.domain

class GetShopListUseCase(private val shopListRepository:ShopListRepository) {
    fun GetShopList(): List<ShopItem> {
        return   shopListRepository.GetShopList()
    }
}