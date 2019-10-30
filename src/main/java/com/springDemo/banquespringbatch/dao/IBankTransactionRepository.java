package com.springDemo.banquespringbatch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBankTransactionRepository extends JpaRepository<BankTransaction, Long> {
}
