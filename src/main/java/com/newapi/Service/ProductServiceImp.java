package com.newapi.Service;

import com.newapi.DTO.ProductListResponseDTO;
import com.newapi.DTO.ProductRequestDTO;
import com.newapi.DTO.ProductResponseDTO;
import com.newapi.Model.Product;
import org.springframework.stereotype.Service;

@Service("ProductService")
public class ProductServiceImp implements ProductService{

    @Override
    public ProductListResponseDTO getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }
    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public Product updateProduct(int id, Product updateProduct) {
        return null;
    }
}
