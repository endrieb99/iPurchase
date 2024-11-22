package com.scally_p.ipurchase.ui.home

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.scally_p.ipurchase.model.products.Product
import com.scally_p.ipurchase.model.report.IPScoreReport
import com.scally_p.ipurchase.model.report.Tweet
import io.realm.RealmList
import org.koin.core.component.KoinComponent

class ProductsViewModel : ViewModel(), KoinComponent {

    private val tag: String = ProductsViewModel::class.java.name

    fun getIPScoreReportFromJson(json: String): IPScoreReport {
        return Gson().fromJson(json, IPScoreReport::class.java)
    }

    val products: ArrayList<Product>
        get() {
            val products: ArrayList<Product> = ArrayList()

            //Images
            val product1 = Product(
                id = 1,
                name = "Apple Watch Series 8",
                identifier = "Apple Series 8",
                images = RealmList(
                    "https://cdn.shopify.com/s/files/1/0568/5942/7015/products/MNJJ3HN_A_2.jpg?v=1662634061",
                    "https://m.media-amazon.com/images/I/71QR6f6Az6L._SX522_.jpg",
                    "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/MKU83_VW_PF+watch-41-alum-midnight-nc-8s_VW_PF_WF_SI?wid=2000&hei=2000&fmt=png-alpha&.v=1632171035000,1661972065024",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MP783ref_VW_PF+watch-41-alum-midnight-nc-8s_VW_PF_WF_CO?wid=1400&hei=1400&trim=1%2C0&fmt=p-jpg&qlt=95&.v=1660779463225%2C1661972065343"
                ),
                colors = RealmList(
                    "#fdc87d",
                    "#b7c2bf",
                    "#efd5d4",
                    "#505a64",
                    "#4b4c50",
                    "#e3ded9"
                ),
                price = 399.00,
                currency = "EUR",
                purchaseLink = "https://www.apple.com/shop/buy-watch/apple-watch",
                releaseDate = "2022-09-16"
            )
            val product2 = Product(
                id = 2,
                name = "iPhone 14 Pro Max",
                identifier = "iPhone 14 Pro Max",
                images = RealmList(
                    "https://www.bigbang.si/upload/catalog/product/976038/c13dd11c9bf787eb46181fb1ae77b0738f246ff50f08e16f4c_6319e31a05a29.jpeg",
                    "https://www.aptronixindia.com/media/catalog/product/i/p/iphone_14_pro_max_deep_purple_pdp_image_position-1a_avail__en-in.jpg",
                    "https://m.media-amazon.com/images/I/31Vle5fVdaL.jpg"
                ),
                colors = RealmList("#61596c", "#f4e8ce", "#f1f3f2", "#454442"),
                price = 999.00,
                currency = "EUR",
                purchaseLink = "https://www.apple.com/shop/buy-iphone/iphone-14-pro",
                releaseDate = "2022-09-16"
            )
            val product3 = Product(
                id = 3,
                name = "iPad Pro",
                identifier = "iPad Pro",
                images = RealmList(
                    "https://media.extra.com/s/aurora/100316127_800/Apple-iPad-Pro-2022%2C-Wi-Fi%2C-11-inch%2C-128GB%2C-Space-Grey?locale=en-GB,en-*,*",
                    "https://m.media-amazon.com/images/I/815a+XjrgvL._SX522_.jpg"
                ),
                colors = RealmList("#aeb2b5", "#dee0df"),
                price = 799.00,
                currency = "EUR",
                purchaseLink = "https://www.apple.com/shop/buy-ipad/ipad-pro",
                releaseDate = "2022-10-26"
            )
            val product4 = Product(
                id = 4,
                name = "Samsung Galaxy S22 Ultra",
                identifier = "Galaxy S22 Ultra",
                images = RealmList(
                    "https://images.samsung.com/is/image/samsung/p6pim/uk/2202/gallery/uk-galaxy-s22-ultra-s908-sm-s908bzwgeub-530847285?\$650_519_PNG\$",
                    "https://www.shopkees.com/cdn/images/1000/5818360408_1644569537.jpg",
                    "https://images.samsung.com/at/smartphones/galaxy-s22-ultra/buy/02_carousel/04_basic-colors/s22_ultra_productkv_burgundy_mo.jpg"
                ),
                colors = RealmList("#5b3d45", "#3a5352", "#f5f5f5", "#262626"),
                price = 1249.00,
                currency = "EUR",
                purchaseLink = "https://www.samsung.com/de/smartphones/galaxy-s22-ultra/buy/",
                releaseDate = "2022-02-25"
            )
            val product5 = Product(
                id = 5,
                name = "Google Pixel 7 Pro",
                identifier = "Pixel 7 Pro",
                images = RealmList(
                    "https://lh3.googleusercontent.com/p4nZ7P33U5gsofMhFc-3zC0_5NlfV8hn_XbQDQ2zLbNnct4zqVttDmTusEnN-aP9VIJJ-ur9oaSDsPuqnYqTtywtnccj63Bv3jE",
                    "https://lh3.googleusercontent.com/YIM1Wg00kFHtTyGRNi1xmOEhqa2WHiQKIfxCTdw0pylcmhyEy4tnZpjeU7FWrG8QHznvzTCaU_iqzV1zgJWpP9IA3uDifn_2HSfJ",
                    "https://lh3.googleusercontent.com/pUCr-SNE-T8XMC77yvmneR9D6jrFAeYyJjiPbHzXWvIiNzWz9wEqtDhnDYERGC3xft3Fun28vwnjaae2NXBF6FexQYQZN8pqJg"
                ),
                colors = RealmList("#888c8a", "#e7e7e7", "#252525"),
                price = 859.00,
                currency = "EUR",
                purchaseLink = "https://store.google.com/de/config/pixel_7_pro?hl=de&selections=eyJQaGEiOiJjR2w0Wld4Zk4xOXdjbTg9In0%3D",
                releaseDate = "2022-10-13"
            )
            val product6 = Product(
                id = 6,
                name = "Airpods Pro 2",
                identifier = "Airpods Pro 2",
                images = RealmList("https://as-images.apple.com/is/MQD83?wid=1000&hei=1000&fmt=jpeg&qlt=95&.v=1660803972361"),
                colors = RealmList("#f5f5f7"),
                price = 249.00,
                currency = "EUR",
                purchaseLink = "https://www.apple.com/shop/product/MQD83AM/A/airpods-pro",
                releaseDate = "2022-09-23"
            )
            val product7 = Product(
                id = 7,
                name = "Airpods Max",
                identifier = "Airpods Max",
                images = RealmList(
                    "https://cdn.shopify.com/s/files/1/0011/0162/7439/products/amsb_1200x.jpg?v=1616762774",
                    "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/airpods-max-select-pink-202011_FMT_WHH?wid=1200&hei=630&fmt=jpeg&qlt=95&.v=1604615276000"
                ),
                colors = RealmList("#595759", "#d8a097", "#afbfab", "#d2d3d4", "#91a6bb"),
                price = 549.00,
                currency = "EUR",
                purchaseLink = "https://www.apple.com/shop/buy-airpods/airpods-max",
                releaseDate = "2020-12-15"
            )
            val product8 = Product(
                id = 8,
                name = "Google Pixel Buds Pro",
                identifier = "Pixel Buds Pro",
                images = RealmList(
                    "https://m.media-amazon.com/images/I/511SXDoIRiL._AC_SY450_.jpg",
                    "https://m.media-amazon.com/images/I/51phYgmbE6L._AC_SX679_.jpg"
                ),
                colors = RealmList("#6e6e6e", "#dae6e7", "#e5e5b1", "#fe9c80"),
                price = 219.00,
                currency = "EUR",
                purchaseLink = "https://store.google.com/de/config/pixel_buds_pro?hl=de",
                releaseDate = "2021-07-17"
            )
            val product9 = Product(
                id = 9,
                name = "Macbook Pro",
                identifier = "Macbook Pro",
                images = RealmList(
                    "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mbp16-spacegray-select-202110?wid=1200&hei=630&fmt=jpeg&qlt=95&.v=1632788574000",
                    "https://p.turbosquid.com/ts-thumb/QN/IpRhYK/XJ/applemacbookpro16inchspacegreymb3dmodel001/jpg/1645092827/600x600/fit_q87/92f0a4e664c3f7bc2781cb7c010ad103b331179d/applemacbookpro16inchspacegreymb3dmodel001.jpg"
                ),
                colors = RealmList("#aeb2b5", "#dee0df"),
                price = 1299.00,
                currency = "EUR",
                purchaseLink = "https://www.apple.com/shop/buy-mac/macbook-pro/16-inch",
                releaseDate = "2021-10-19"
            )
            val product10 = Product(
                id = 10,
                name = "Macbook Air",
                identifier = "Macbook Air",
                images = RealmList(
                    "https://media.ldlc.com/r1600/ld/products/00/05/95/96/LD0005959611.jpg",
                    "https://geschaeftskunden.telekom.de/eccp/resources/resp-images/7286/ratio4x3/3556/2667/5bb522d35169698a09e87f7e0d9bfbd4/f1e3/macbook-air-m2-chip-4-up-hero-screen--wwen.png"
                ),
                colors = RealmList("#625a6d", "#f4e8ce", "#f1f3f2", "#4c4b49"),
                price = 999.00,
                currency = "EUR",
                purchaseLink = "https://www.apple.com/shop/buy-mac/macbook-air/m2-chip",
                releaseDate = "2021-10-19"
            )
            val product12 = Product(
                id = 12,
                name = "Sony WH-1000XM5",
                identifier = "Sony WH-1000XM5",
                images = RealmList("https://www.sony.de/image/6145c1d32e6ac8e63a46c912dc33c5bb?fmt=pjpeg&wid=330&bgcolor=FFFFFF&bgc=FFFFFF"),
                colors = RealmList("#c0c0c0", "#000000"),
                price = 399.00,
                currency = "EUR",
                purchaseLink = "https://www.sony.de/store/product/wh1000xm5b.ce7/WH-1000XM5-kabellose-Kopfh%C3%B6rer-mit-Noise-Cancelling",
                releaseDate = "2022-05-20"
            )
            val product11 = Product(
                id = 11,
                name = "Samsung Z Fold4",
                identifier = "Z Fold4",
                images = RealmList(
                    "https://m.media-amazon.com/images/I/61cInRWmClL._SL1500_.jpg",
                    "https://m.media-amazon.com/images/I/714QNdK8BWL._SX679_.jpg"
                ),
                colors = RealmList("#4e5a61", "#2d2926", "#d6cec1"),
                price = 1799.00,
                currency = "EUR",
                purchaseLink = "https://www.samsung.com/de/smartphones/galaxy-z-fold4/buy/",
                releaseDate = "2022-08-25"
            )
            val product13 = Product(
                id = 13,
                name = "XBOX Series X",
                identifier = "XBOX Series X",
                images = RealmList("https://mediacore.kyuubi.it/aedgaming/media/img/2022/11/23/492527-large-xbox-series-x-1tb-it.jpg"),
                colors = RealmList("#313131"),
                price = 499.99,
                currency = "EUR",
                purchaseLink = "https://www.xbox.com/de-de/configure/8WJ714N3RBTL",
                releaseDate = "2020-11-10"
            )
            val product14 = Product(
                id = 14,
                name = "Play Station 5 Disc",
                identifier = "PS5 Disc",
                images = RealmList("https://media.cdn.kaufland.de/product-images/1024x1024/2caa79f5d90a8df3a830f518b2d48de1.jpg"),
                colors = RealmList("#e7ebf5"),
                price = 549.99,
                currency = "EUR",
                purchaseLink = "https://direct.playstation.com/de-de/buy-consoles/playstation5-console",
                releaseDate = "2020-11-12"
            )
            val product15 = Product(
                id = 15,
                name = "Play Station 5 Digital",
                identifier = "PS5 Digital",
                images = RealmList("https://i5.walmartimages.com/asr/825493ab-d9d7-4e0e-92ce-5e9ee41a0e59.a3f02790fc0611920245c5046aaae481.jpeg"),
                colors = RealmList("#e7ebf5"),
                price = 499.99,
                currency = "EUR",
                purchaseLink = "https://direct.playstation.com/de-de/buy-consoles/playstation5-digital-edition-console",
                releaseDate = "2020-11-12"
            )
            val product16 = Product(
                id = 16,
                name = "Apple Studio Display",
                identifier = "Apple Studio Display",
                images = RealmList("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/refurb-mac-studio-display-tilt-202206_AV1?wid=1144&hei=1144&fmt=jpeg&qlt=90&.v=1654798376819"),
                colors = RealmList("#d9dadc"),
                price = 1599.99,
                currency = "EUR",
                purchaseLink = "https://www.apple.com/shop/buy-mac/apple-studio-display",
                releaseDate = "2022-03-18"
            )
            val product17 = Product(
                id = 17,
                name = "Apple Pro Display XDR",
                identifier = "Pro Display XDR",
                images = RealmList("https://droider.ru/wp-content/uploads/2022/01/2zbvxg3v-900.jpg"),
                colors = RealmList("#d9dadc"),
                price = 4999.99,
                currency = "EUR",
                purchaseLink = "https://www.apple.com/shop/buy-mac/pro-display-xdr",
                releaseDate = "2019-12-10"
            )

            products.add(product2)
            products.add(product5)
            products.add(product4)
            products.add(product3)
            products.add(product11)
            products.add(product1)
            products.add(product6)
            products.add(product7)
            products.add(product8)
            products.add(product12)
            products.add(product9)
            products.add(product10)
            products.add(product13)
            products.add(product14)
            products.add(product15)
            products.add(product16)
            products.add(product17)

            return products
        }
}