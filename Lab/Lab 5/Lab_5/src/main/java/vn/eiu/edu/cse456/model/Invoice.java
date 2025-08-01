package vn.eiu.edu.cse456.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InvoiceItem> items = new ArrayList<>();

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "invoice_date")
    private LocalDateTime invoiceDate;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.invoiceDate = LocalDateTime.now();
        this.totalAmount = 0.0;
    }
}
