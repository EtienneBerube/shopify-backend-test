class CreateJoinTableShoppingCartsProducts < ActiveRecord::Migration[5.1]
  def change
    create_join_table :shopping_carts, :products do |t|
      t.index [:shopping_cart_id, :product_id]
      t.index [:product_id, :shopping_cart_id]
    end
  end
end
