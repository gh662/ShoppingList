package ru.td.shoppinglist.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val shopListRepository:ShopListRepository) {
    fun GetShopList(): LiveData<List<ShopItem>> {
        return   shopListRepository.GetShopList()
    }
}