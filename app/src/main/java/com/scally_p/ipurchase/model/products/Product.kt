package com.scally_p.ipurchase.model.products

import io.realm.RealmList
import io.realm.annotations.PrimaryKey

data class Product(
    @PrimaryKey
    var id: Int? = null,
    var category: Category? = null,
    var brand: Brand? = null,
    var name: String? = null,
    var identifier: String? = null,
    var images: RealmList<String>? = null,
    var colors: RealmList<String>? = null,
    var price: Double? = null,
    var currency: String? = null,
    var storage: String? = null,
    var purchaseLink: String? = null,
    var description: String? = null,
    var releaseDate: String? = null,
)