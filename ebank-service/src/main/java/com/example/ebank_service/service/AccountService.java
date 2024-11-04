package com.example.ebank_service.service;

import com.example.ebank_service.dto.BankAccountRequestDto;
import com.example.ebank_service.dto.BankAccountResponseDto;
import com.example.ebank_service.entities.BankAccount;

public interface AccountService {
     BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto);
}
