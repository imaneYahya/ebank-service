package com.example.ebank_service.dto;

import com.example.ebank_service.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountResponseDto {

    private String id;
    private Date createdAt;
    private Double balance;
    private AccountType type;
    private String currency;
}
