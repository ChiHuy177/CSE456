package vn.eiu.edu.cse456.service;

import org.springframework.stereotype.Service;
import vn.eiu.edu.cse456.model.Invoice;
import vn.eiu.edu.cse456.model.InvoiceItem;

@Service
public class PdfService {
    public void exportInvoiceToPdf(Invoice invoice) {
        System.out.println("Invoice #" + invoice.getId() + " - Customer: " + invoice.getCustomer().getName()
                + " - Total: $" + invoice.getTotalAmount());
        System.out.println("Items: " + invoice.getItems().size() + " products - Date: " + invoice.getInvoiceDate());
        for (InvoiceItem item : invoice.getItems()) {
            System.out.println("Product: " + item.getProduct().getName() + " - Quantity: " + item.getQuantity()
                    + " - Price: $" + item.getUnitPrice() + " - Subtotal: $" + item.getSubtotal());
        }
    }
}
