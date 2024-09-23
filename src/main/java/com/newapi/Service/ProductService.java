package com.newapi.Service;

import com.newapi.DTO.ProductListResponseDTO;
import com.newapi.DTO.ProductRequestDTO;
import com.newapi.DTO.ProductResponseDTO;
import com.newapi.Model.Product;

public interface ProductService {
ProductListResponseDTO getAllProducts();
ProductResponseDTO getProductById(int id);
ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
boolean deleteProduct(int id);
Product updateProduct(int id, Product updateProduct);
}
