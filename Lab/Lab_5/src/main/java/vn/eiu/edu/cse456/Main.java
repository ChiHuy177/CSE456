package vn.eiu.edu.cse456;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vn.eiu.edu.cse456.config.AppConfig;
import vn.eiu.edu.cse456.model.Customer;
import vn.eiu.edu.cse456.model.Product;
import vn.eiu.edu.cse456.repository.CustomerRepository;
import vn.eiu.edu.cse456.repository.ProductRepository;
import vn.eiu.edu.cse456.service.CustomerService;
import vn.eiu.edu.cse456.service.ProductService;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService = context.getBean(CustomerService.class);

        ProductService productService = context.getBean(ProductService.class);

        Customer customer1 = new Customer("John Doe", "john.doe@example.com");
        customerService.addCustomer(customer1);

        Product product1 = new Product("iPhone 12", 1200000);
        Product product2 = new Product("Samsung Galaxy S21", 700000);
        Product product3 = new Product("Huawei Mate 40", 500000);

        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);

        List<Product> products = productService.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }
}