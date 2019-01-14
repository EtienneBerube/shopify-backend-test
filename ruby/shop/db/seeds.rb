#Creating dummy inventory

5.times do
  Product.create({
                     title: Faker::Commerce.product_name,
                     price: Faker::Commerce.price,
                     inventory_count: Faker::Number.number(2)
                 })

end

3.times do
  ShoppingCart.create({
                                 total_price: 0
                             }) do |t|


  User.create({
                  name: Faker::Name.name,
                  shopping_carts_id: t.id
              })
    end
end