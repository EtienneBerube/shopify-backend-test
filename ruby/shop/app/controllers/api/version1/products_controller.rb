module Api
  module Version1

    class ProductsController < ApplicationController
      def index
        products = Product.order('title DESC');
        render json: {status: 'Success', message: 'Loaded articles', data: products}, status: :ok
      end

      def show
        product = Product.find(params[:id])
        render json: {status: 'Success', message: 'Loaded articles', data: product}, status: :ok
      end

      def create
        product = Product.new(product_params)

        if product.save
          render json: {status: 'Success', message: 'saved article', data: product}, status: :ok
        else
          render json: {status: 'Error', message: 'Article not saved', data: product.errors}, status: :unprocessable_entry
        end
      end

      private

      def product_params
        params.permit(:title, :price, :inventory_count)
      end
    end

  end
end