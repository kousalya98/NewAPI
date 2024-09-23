package com.newapi.Service;

import com.newapi.DTO.ProductListResponseDTO;
import com.newapi.DTO.ProductRequestDTO;
import com.newapi.DTO.ProductResponseDTO;
import com.newapi.Model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService  {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    @Override
    public ProductListResponseDTO getAllProducts() {
        String getAllProductsURL="https://fakestoreapi.com/products";
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO[]> productResponseArray= restTemplate.getForEntity(getAllProductsURL, (Class<ProductResponseDTO[]>) ProductResponseDTO[].class);
     ProductListResponseDTO responseDTO= new ProductListResponseDTO();
     for(ProductResponseDTO productResponse : productResponseArray.getBody()) {
            responseDTO.getProduct().add(productResponse);
        }
        return responseDTO;
    }


    @Override
    public ProductResponseDTO getProductById(int id) {
        String getAllProductsURL="https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productRespone= restTemplate.getForEntity(getAllProductsURL,ProductResponseDTO.class);
        return productRespone.getBody();
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        String createProductURL="https://fakestoreapi.com/products/";
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse=restTemplate.postForEntity(createProductURL, productRequestDTO,ProductResponseDTO.class);
        return productResponse.getBody();
    }


    @Override
    public boolean deleteProduct(int id) {
        String productDeleteURL="https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate=restTemplateBuilder.build();
        restTemplate.delete(productDeleteURL);
        return true;
    }

    @Override
    public Product updateProduct(int id, Product updateProduct) {
        return null;
    }
}
