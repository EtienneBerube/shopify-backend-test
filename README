
Welcome to my home made e-commerce API!
by Etienne Berube

Set-Up:
Database used is MySQL. There needs to be a database called "shop" that runs at the standard "localhost:3306" address. The user and password are the very original:
username:root
password:admin

API:

GET /products:
  -Shows all the products
param: showOnlyAvailable (OPTIONAL)
  -Whether to show all items or only the ones that are available (inventory count > 0)
  
GET /products/{id}
  -Shows one product
path variable: id
  -The id of the requested product
  
POST /products/new
  -Adds a new product
body: product
  -the product to be added. Must follow the following syntax
  
  {
        "id": 1,
        "title": "Computer",
        "price": 50.1,
        "inventory_count": 3
  }
  
  PUT /{userID}/add-to-cart
    -Adds a product in a user's cart
  path variable: id
    -The id of the user to add the produt in his shopping cart
  param: id
    -The id of the product
  param: quantity
    -The quantity to be added in the cart (cannot ask for more than the inventory count)
    
  GET /{userID}/cart
    -Returns the cart of a user
  path variable: id
    -The id of the user to add the produt in his shopping cart
    
  PUT /{userId}/remove-from-cart
    -Removes a given quantity (or all of it) of a product in a user's cart
  path variable: id
    -The id of the user to add the produt in his shopping cart
  param: id
    -The id of the product
  param: removeAll (OPTIONAL)
    -Whether to remove the product from the cart (regardless of the quantity)
  param: quantity (OPTIONAL)
    -The quantity to remove from the cart
    
   PUT /{userId}/checkout
    -Clears the cart and removes the requested ammount from the inventory count of the items. Some items that have been there for a          while may have had a sufficient ammount when added but not now (other users have bought the item). Those items will remain in the        cart.
   path variable: id
    -The id of the user to add the produt in his shopping cart
    
   POST /user/new
      -Creates a new user
   param: name
      -Name of the new user
      
    
  
  
  
    
    
