class AddingFk < ActiveRecord::Migration[5.1]
  def change
    add_reference :users, :shopping_carts, index: true, foreign_key: true
  end
end
