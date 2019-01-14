
#Creating dummy inventory

5.times do
  Product.create({
                     title: Faker::Commerce.product_name,
                     price: Faker::Commerce.price,
                     inventory_count: Faker::Number.number(2)
                 })

end