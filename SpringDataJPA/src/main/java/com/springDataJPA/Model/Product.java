package com.springDataJPA.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblProduct",
		schema = "productcrud",
		uniqueConstraints = {
				@UniqueConstraint(name="sku_unique",columnNames = "stock_keeping_unit")
		}
)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "stock_keeping_unit",nullable = false)
	private String sku;
	@Column(nullable = false)
	private String name;
	private String description;
	private Double price;
	private boolean active;
	private String imageUrl;
	private LocalDateTime dateCreated;
	private LocalDateTime lastUpDate;
	
}
