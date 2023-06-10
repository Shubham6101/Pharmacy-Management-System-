package com.DrugManagement.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "drugs")
public class Drug {
	@Id
    private String drugId;
	
    @NotBlank(message = "Drug name is required")
    private String drugName;
    
    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
    
    @NotNull(message = "Expiry date is required")
    private LocalDate expiryDate;
    
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01")
    private BigDecimal price;

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Drug(String drugId, @NotBlank(message = "Drug name is required") String drugName,
			@NotNull(message = "Quantity is required") @Min(value = 1, message = "Quantity must be at least 1") Integer quantity,
			@NotNull(message = "Expiry date is required") LocalDate expiryDate,
			@NotNull(message = "Price is required") @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01") BigDecimal price) {
		super();
		this.drugId = drugId;
		this.drugName = drugName;
		this.quantity = quantity;
		this.expiryDate = expiryDate;
		this.price = price;
	}

	public Drug() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

