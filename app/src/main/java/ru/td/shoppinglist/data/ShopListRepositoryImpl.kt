package ru.td.shoppinglist.data

import ru.td.shoppinglist.domain.ShopItem
import ru.td.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl: ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i",i,true)
            AddShopItem(item)

        }
    }

    override fun AddShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFIND_ID){
        shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)

    }

    override fun DeleteShopItem(ShopItem: ShopItem) {
       shopList.remove(ShopItem)
    }

    override fun EditShopItem(ShopItem: ShopItem) {
        val oldElement = GetShopItem(ShopItem.id)
        shopList.remove(oldElement)
        AddShopItem(ShopItem)
    }

    override fun GetShopItem(ShopItemId: Int): ShopItem {
        return shopList.find {
            it.id == ShopItemId }?: throw  RuntimeException("Element with id $ShopItemId not find")
    }

    override fun GetShopList(): List<ShopItem> {
       return  shopList.toList()
    }

}