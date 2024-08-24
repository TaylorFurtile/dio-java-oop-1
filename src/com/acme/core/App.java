package com.acme.core;

import com.acme.core.account.Account;
import com.acme.core.account.CheckingAccount;
import com.acme.core.exception.AccountException;
import com.acme.core.exception.ClientException;
import com.acme.core.exception.TransactionException;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        try {
            Bank bank = Bank.create();
            Client client = new Client("111.111.111-11");
            Account account = new CheckingAccount(bank, client);
            ArrayList<Agency> agencies = new ArrayList<>(bank.getAgencies());
            Agency randomAgency = agencies.get(new Random().nextInt(0, agencies.size()));

            account.setAgency(randomAgency);
            client.setName("Teste");
            client.setEmail("teste@teste.com.br");

            account.deposit(account.startTransaction(50));
            account.withdraw(account.startTransaction(10));
            
            System.out.println(String.format("Welcome back %s", client.getName()));

            System.out.println(String.format("Your balance is %s", account.getFormattedBalance()));

            System.out.println(String.format("Your agency is %s", account.getAgency()));
        } catch (ClientException e) {
            System.err.println("Error on client: " + e.getMessage());
        } catch (TransactionException e) {
            System.err.println("Error on transaction: " + e.getMessage());
        } catch (AccountException e) {
            System.err.println("Error on account: " + e.getMessage());
        }
    }
}
