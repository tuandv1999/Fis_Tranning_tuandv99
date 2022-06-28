package vn.fis.training.ordermanagement.service;


import vn.fis.training.ordermanagement.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProductById(Long productId);
    List<Product> findAll();
}
