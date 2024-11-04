package com.example.ebank_service.entities;

import com.example.ebank_service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "P1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
