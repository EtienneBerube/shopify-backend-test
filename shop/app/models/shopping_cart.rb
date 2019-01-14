class ShoppingCart < ApplicationRecord
  belongs_to :owner
  belongs_to :products
end
