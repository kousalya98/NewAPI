package com.newapi.Controller;

import com.newapi.DTO.ProductListResponseDTO;
import com.newapi.DTO.ProductRequestDTO;
import com.newapi.DTO.ProductResponseDTO;
import com.newapi.Model.Product;
import com.newapi.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

  /** Field injection
   // @Autowired
    //@Qualifier("FakeStoreProductService")
    //private ProductService IproductService;
*/
  private final ProductService productService;
  @Autowired
  public ProductController(@Qualifier("FakeStoreProductService")ProductService productService){
      this.productService=productService;
  }
    @GetMapping("/products/{id}")

    public ResponseEntity getProductId(@PathVariable("id") int id){
        ProductResponseDTO response= productService.getProductById(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/products")
    public ResponseEntity getAllProduct(){
      ProductListResponseDTO response=productService.getAllProducts();
      return ResponseEntity.ok(response);
    }
    @PostMapping("/products")
    public ResponseEntity createProdcut(@RequestBody ProductRequestDTO productRequestDTO){
    ProductResponseDTO responseDTO=productService.createProduct(productRequestDTO);
    return ResponseEntity.ok(responseDTO);
    }
    @DeleteMapping("/products/{id}")
  public ResponseEntity deleteProductByid(@PathVariable("id") int id)
    {
      boolean response =productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }
}
