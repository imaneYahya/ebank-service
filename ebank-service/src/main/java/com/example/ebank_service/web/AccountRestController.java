package com.example.ebank_service.web;

import com.example.ebank_service.dto.BankAccountRequestDto;
import com.example.ebank_service.dto.BankAccountResponseDto;
import com.example.ebank_service.entities.BankAccount;
import com.example.ebank_service.mappers.AccountMapper;
import com.example.ebank_service.repositories.BankAccountRepository;
import com.example.ebank_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccount")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();

    }

    @GetMapping("/bankAccount/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("account not found", id)));

    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDto save(@RequestBody BankAccountRequestDto bankAccountRequestDto){
        return accountService.addAccount(bankAccountRequestDto);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
       if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
       if(bankAccount.getCreatedAt()!=null) account.setCreatedAt(new Date());
       if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getType()!=null)  account.setType(bankAccount.getType());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
