package vn.eiu.edu.cse456;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vn.eiu.edu.cse456.config.AppConfig;
import vn.eiu.edu.cse456.model.Customer;
import vn.eiu.edu.cse456.model.Invoice;
import vn.eiu.edu.cse456.model.Product;
import vn.eiu.edu.cse456.repository.InvoiceRepository;
import vn.eiu.edu.cse456.service.CustomerService;
import vn.eiu.edu.cse456.service.InvoiceService;
import vn.eiu.edu.cse456.service.PdfService;
import vn.eiu.edu.cse456.service.ProductService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService = context.getBean(CustomerService.class);
        ProductService productService = context.getBean(ProductService.class);
        InvoiceService invoiceService = context.getBean(InvoiceService.class);
        InvoiceRepository invoiceRepository = context.getBean(InvoiceRepository.class);
        PdfService pdfService = context.getBean(PdfService.class);

        // Tạo customer
        Customer customer1 = new Customer("Chí Huệ", "chihuy@gmail.com");
        customerService.addCustomer(customer1);

        // Tạo products
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


        // Tạo invoice mới
        Invoice invoice = new Invoice(customer1);

        // Thêm nhiều sản phẩm vào invoice
        invoiceService.addItemToInvoice(invoice, product1, 2); // 2 iPhone 12
        invoiceService.addItemToInvoice(invoice, product2, 1); // 1 Samsung Galaxy S21
        invoiceService.addItemToInvoice(invoice, product3, 3); // 3 Huawei Mate 40

        invoiceRepository.save(invoice);


        Product product4 = new Product("MacBook Pro", 3500000);
        productService.addProduct(product4);

        invoiceService.addItemToInvoice(invoice, product4, 1); // Thêm 1 MacBook Pro
        invoiceRepository.update(invoice);

        pdfService.exportInvoiceToPdf(invoice);
    }
}