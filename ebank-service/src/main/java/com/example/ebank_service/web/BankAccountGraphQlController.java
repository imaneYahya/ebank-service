package com.example.ebank_service.web;


import com.example.ebank_service.entities.BankAccount;
import com.example.ebank_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;


    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();



    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account %s not found",id)));



    }


    public BankAccount addAccount(@Argument  BankAccountDto bankAccountDto){
      return   bankAccountRepository.save(bankAccountDto);
    }
}

record BankAccountDto(Double balance, String type, String currency){


}
