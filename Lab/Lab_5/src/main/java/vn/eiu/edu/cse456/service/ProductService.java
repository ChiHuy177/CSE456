package vn.eiu.edu.cse456.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.eiu.edu.cse456.model.Product;
import vn.eiu.edu.cse456.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Product getProductById(int id){
        return productRepository.findById(id);
    }

    public void updateProduct(Product product){
        productRepository.update(product);
    }
    public void deleteProduct(int id){
        productRepository.delete(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
