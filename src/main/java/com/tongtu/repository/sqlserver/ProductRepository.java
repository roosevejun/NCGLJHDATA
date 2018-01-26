package com.tongtu.repository.sqlserver;

import com.tongtu.bean.sqlserver.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
