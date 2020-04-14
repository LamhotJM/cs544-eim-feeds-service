# Service for products feeds
- This service will have responsibility as consumer in messaging system, after merchant add new product, then will be store to Mongodb
- There is batch system to remove old product from feeds (only show 2 products)
- Display 2 product feeds "http://localhost:8081/api/products"

Get - http://localhost:8081/api/products

Output:

```json
{
    "data": [
        {
            "id": "5e95094179239f61d1c44dbe",
            "productNumber": null,
            "title": "title II",
            "summary": "summary of the product",
            "description": "this kind of electronics ",
            "discount": 10.0,
            "price": 890.65,
            "qtyAvail": 40,
            "imageUrl": "http://localhost:8080/productimages/Lg_32_inch_6370826_sd.jpg",
            "available": true
        }
    ],
    "erros": null
}

```

POST - http://localhost:8081/api/products
```json
{
  "description": "this kind of electronics ",
  "discount": 10,
  "price": 890.65,
  "qtyAvail": 40,
  "summary": "summary of the product",
  "title": "title II",
  "imageUrl":"http://localhost:8080/productimages/Lg_32_inch_6370826_sd.jpg"
}
```


