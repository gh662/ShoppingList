package ru.td.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.td.shoppinglist.data.ShopListRepositoryImpl
import ru.td.shoppinglist.domain.DeleteShopItemUseCase
import ru.td.shoppinglist.domain.EditShopItemUseCase
import ru.td.shoppinglist.domain.GetShopListUseCase
import ru.td.shoppinglist.domain.ShopItem

class MainViewModel:ViewModel() {

    private  val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList(){
        val list = getShopListUseCase.GetShopList()
        shopList.value = list
    }

    fun getShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.DeleteShopItem(shopItem)
        getShopList()
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled =  !shopItem.enabled)
        editShopItemUseCase.EditShopItem(newItem)
        getShopList()

    }

}