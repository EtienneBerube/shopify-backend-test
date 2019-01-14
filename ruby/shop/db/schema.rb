# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20190114210533) do

  create_table "products", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci" do |t|
    t.string "title", limit: 50
    t.float "price", limit: 24
    t.integer "inventory_count"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "products_shopping_carts", id: false, force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci" do |t|
    t.bigint "shopping_cart_id", null: false
    t.bigint "product_id", null: false
    t.index ["product_id", "shopping_cart_id"], name: "index_products_shopping_carts_on_product_id_and_shopping_cart_id"
    t.index ["shopping_cart_id", "product_id"], name: "index_products_shopping_carts_on_shopping_cart_id_and_product_id"
  end

  create_table "shopping_carts", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci" do |t|
    t.float "total_price", limit: 24
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "users", force: :cascade, options: "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci" do |t|
    t.string "name"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.bigint "shopping_carts_id"
    t.index ["shopping_carts_id"], name: "index_users_on_shopping_carts_id"
  end

  add_foreign_key "users", "shopping_carts", column: "shopping_carts_id"
end
