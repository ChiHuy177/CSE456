package vn.eiu.edu.cse456.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.eiu.edu.cse456.model.Customer;
import vn.eiu.edu.cse456.model.Invoice;
import vn.eiu.edu.cse456.model.Product;
import vn.eiu.edu.cse456.repository.CustomerRepository;
import vn.eiu.edu.cse456.repository.InvoiceRepository;
import vn.eiu.edu.cse456.repository.ProductRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Map;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ProductService productService;

    public void generateInvoice(int customerId, Map<Integer, Integer> productQuantities) {
        // Lấy thông tin customer
        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            throw new RuntimeException("Không tìm thấy customer với ID: " + customerId);
        }
        
        double totalAmount = 0.0;
        List<String> productDetails = new ArrayList<>();
        
        // Tạo từng invoice cho mỗi product
        for (Map.Entry<Integer, Integer> entry : productQuantities.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();
            
            Product product = productService.getProductById(productId);
            if (product == null) {
                throw new RuntimeException("Không tìm thấy product với ID: " + productId);
            }
            
            // Tạo invoice cho từng product
            Invoice invoice = new Invoice(customer, product, quantity);
            invoiceRepository.save(invoice);
            
            totalAmount += invoice.getTotalAmount();
            productDetails.add(String.format("%s - SL: %d - Giá: %.0f", 
                product.getName(), quantity, invoice.getTotalAmount()));
        }
        
        // Export PDF (simulate ra console)
        exportInvoiceToPdf(customer, productDetails, totalAmount);
    }
    
    private void exportInvoiceToPdf(Customer customer, List<String> productDetails, double totalAmount) {
        System.out.println("=".repeat(60));
        System.out.println("                    HÓA ĐƠN BÁN HÀNG");
        System.out.println("=".repeat(60));
        
        System.out.println("Ngày: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println();
        
        System.out.println("THÔNG TIN KHÁCH HÀNG:");
        System.out.println("Tên: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println();
        
        System.out.println("DANH SÁCH SẢN PHẨM:");
        System.out.println("-".repeat(60));
        
        for (int i = 0; i < productDetails.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, productDetails.get(i));
        }
        
        System.out.println("-".repeat(60));
        System.out.printf("TỔNG CỘNG: %.0f VNĐ%n", totalAmount);
        System.out.println("=".repeat(60));
        System.out.println("Cảm ơn quý khách đã mua hàng!");
        System.out.println("=".repeat(60));
    }
}
