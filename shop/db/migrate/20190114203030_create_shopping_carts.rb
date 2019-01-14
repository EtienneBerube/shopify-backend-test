class CreateShoppingCarts < ActiveRecord::Migration[5.1]
  def change
    create_table :shopping_carts do |t|
      t.references :owner, foreign_key: true
      t.references :products, foreign_key: true
      t.float :total_price

      t.timestamps
    end
  end
end
