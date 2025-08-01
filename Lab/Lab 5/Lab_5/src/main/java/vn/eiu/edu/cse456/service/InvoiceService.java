package vn.eiu.edu.cse456.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.eiu.edu.cse456.model.Customer;
import vn.eiu.edu.cse456.model.Invoice;
import vn.eiu.edu.cse456.model.InvoiceItem;
import vn.eiu.edu.cse456.model.Product;
import vn.eiu.edu.cse456.repository.InvoiceRepository;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    public void generateInvoice(int customerId, int productId, int quantity) {
        // Lấy thông tin customer
        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            throw new RuntimeException("Không tìm thấy customer với ID: " + customerId);
        }

        // Lấy thông tin product
        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new RuntimeException("Không tìm thấy product với ID: " + productId);
        }

        // Validation quantity
        if (quantity <= 0) {
            throw new IllegalArgumentException("Số lượng phải lớn hơn 0");
        }

        // Tạo invoice
        Invoice invoice = new Invoice(customer);
        addItemToInvoice(invoice, product, quantity);

        // Lưu invoice
        invoiceRepository.save(invoice);

    }

    // Thêm sản phẩm vào invoice
    public void addItemToInvoice(Invoice invoice, Product product, int quantity) {
        InvoiceItem item = new InvoiceItem(invoice, product, quantity);
        invoice.getItems().add(item);
        calculateTotalAmount(invoice);
    }

    // Xóa sản phẩm khỏi invoice
    public void removeItemFromInvoice(Invoice invoice, InvoiceItem item) {
        invoice.getItems().remove(item);
        calculateTotalAmount(invoice);
    }

    // Tính tổng tiền invoice
    public void calculateTotalAmount(Invoice invoice) {
        double total = 0.0;
        for (InvoiceItem item : invoice.getItems()) {
            total += item.getSubtotal();
        }
        invoice.setTotalAmount(total);
    }

    // Đếm tổng số lượng sản phẩm trong invoice
    public int getTotalItems(Invoice invoice) {
        int total = 0;
        for (InvoiceItem item : invoice.getItems()) {
            total += item.getQuantity();
        }
        return total;
    }
}
