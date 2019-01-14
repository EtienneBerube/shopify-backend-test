class CreateProducts < ActiveRecord::Migration[5.1]
  def change
    create_table :products do |t|
      t.integer :title
      t.float :price
      t.integer :inventory_count

      t.timestamps
    end
  end
end
