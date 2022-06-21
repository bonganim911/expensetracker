package com.bongz.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="expense_name")
    private String name;

    private String description;

    @Column(name="expense_amount")
    private BigDecimal amount;

    private Date date;

    @CreationTimestamp
    @Column(name="created_date", nullable = false, updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name="updated_date")
    private Timestamp updatedAt;
}
