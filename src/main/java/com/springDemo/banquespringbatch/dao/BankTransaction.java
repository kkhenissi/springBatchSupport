package com.springDemo.banquespringbatch.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class BankTransaction {
    @javax.persistence.Id
    private Long Id;
    private long accountId;
    private Date transactionDate;
    @Transient
    private String strTransactionDate;
    private String transactionType;
    private Double amount;
}
