package com.neoteric.dec_dbconnection.creditcard.service;

import com.neoteric.dec_dbconnection.creditcard.model.BillPeriodDTO;
import com.neoteric.dec_dbconnection.creditcard.model.CreditCardDTO;
import com.neoteric.dec_dbconnection.creditcard.model.EMIDTO;
import com.neoteric.dec_dbconnection.creditcard.model.TransactionDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Date;

public class CreditCardTest {
    public static void main(String[] args) {

        CreditCardService creditCardService = new CreditCardService();
        CreditCardDTO creditCardDTO = new CreditCardDTO();
        creditCardDTO.setCardNumber("1234-5678-9876-5432");
        creditCardDTO.setCreditLimit(50000.0);
        creditCardDTO.setStatus("active");

        creditCardService.saveCreditCard(creditCardDTO);

       TransactionService transactionService = new TransactionService();

        TransactionDTO txn1 = new TransactionDTO();
        txn1.setAmount(100.0);
        txn1.setType("debit");
        txn1.setTransactionId("tnx1");
        txn1.setDate(LocalDate.of(2024, 12, 3));
        txn1.setStatus("sucess");

        TransactionDTO txn2 = new TransactionDTO();
        txn2.setAmount(100.0);
        txn2.setType("debit");
        txn2.setTransactionId("txn2");
        txn2.setDate(LocalDate.of(2024, 11, 4));
        txn2.setStatus("sucess");

        TransactionDTO txn3 = new TransactionDTO();
        txn3.setAmount(100.0);
        txn3.setType("debit");
        txn3.setTransactionId("txn3");
        txn3.setDate(LocalDate.of(2024, 10, 5));
        txn3.setStatus("sucess");

        TransactionDTO txn4 = new TransactionDTO();
        txn4.setAmount(100.0);
        txn4.setType("debit");
        txn4.setTransactionId("txn4");
        txn4.setDate(LocalDate.of(2024, 9, 6));
        txn4.setStatus("sucess");

        TransactionDTO txn5 = new TransactionDTO();
        txn5.setAmount(100.0);
        txn5.setType("debit");
        txn5.setTransactionId("tnx1");
        txn5.setDate(LocalDate.of(2024, 8, 7));
        txn5.setStatus("sucess");

        TransactionDTO txn6 = new TransactionDTO();
        txn6.setAmount(100.0);
        txn6.setType("debit");
        txn6.setTransactionId("txn6");
        txn6.setDate(LocalDate.of(2024, 7, 8));
        txn6.setStatus("sucess");

        TransactionDTO txn7 = new TransactionDTO();
        txn7.setAmount(100.0);
        txn7.setType("debit");
        txn7.setTransactionId("txn7");
        txn7.setDate(LocalDate.of(2024, 6, 9));
        txn7.setStatus("sucess");

        TransactionDTO txn8 = new TransactionDTO();
        txn8.setAmount(100.0);
        txn8.setType("debit");
        txn8.setTransactionId("txn8");
        txn8.setDate(LocalDate.of(2024, 5, 10));
        txn8.setStatus("sucess");

        TransactionDTO txn9 = new TransactionDTO();
        txn9.setAmount(100.0);
        txn9.setType("debit");
        txn9.setTransactionId("txn9");
        txn9.setDate(LocalDate.of(2024, 4, 9));
        txn9.setStatus("sucess");

     TransactionDTO txn11 = new TransactionDTO();
     txn11.setAmount(1000.0);
     txn11.setType("debit");
     txn11.setTransactionId("txn11");
     txn11.setDate(LocalDate.of(2024, 2, 9));
     txn11.setStatus("sucess");

        TransactionDTO txn10 = new TransactionDTO();
        txn10.setAmount(1000.0);
        txn10.setType("credit");
        txn10.setTransactionId("txn10");
        txn10.setDate(LocalDate.of(2024, 5, 9));
        txn10.setStatus("sucess");


     transactionService.addTransaction(creditCardDTO,txn2);
     transactionService.addTransaction(creditCardDTO,txn1);
     transactionService.addTransaction(creditCardDTO,txn3);
     transactionService.addTransaction(creditCardDTO,txn4);
     transactionService.addTransaction(creditCardDTO,txn5);
     transactionService.addTransaction(creditCardDTO,txn6);
     transactionService.addTransaction(creditCardDTO,txn7);
     transactionService.addTransaction(creditCardDTO,txn8);
     transactionService.addTransaction(creditCardDTO,txn9);
     transactionService.addTransaction(creditCardDTO,txn11);
     transactionService.addTransaction(creditCardDTO,txn10);
     transactionService.calculateCreditTotal(creditCardDTO);
     transactionService.calculateDebitTotal(creditCardDTO);

     BillService billservice = new BillService();
     BillPeriodDTO  billPeriodDTO = new BillPeriodDTO();
     billPeriodDTO.setFromDate(LocalDate.of(2024, 12, 20));
     billPeriodDTO.setToDate(LocalDate.of(2024,12,25));
     billPeriodDTO.setStatus("active");
     billservice.saveBillPeriod(billPeriodDTO);

     creditCardDTO.setBillPeriod(billPeriodDTO);

     EMIService emiservice = new EMIService();

     EMIDTO emidto = new EMIDTO();
     emiservice.saveEMI(emidto);
     emiservice.convertToEMI(creditCardDTO, 12, 10.0, 100.0); // Example: 12 months, 10% interest, Rs. 500 monthly expense
      System.out.println("EMI conversion successful!");

     }
    }



//       CreditCardDTO fetchedCreditCard = creditCardService.findCreditCardById(1234-5678-9876-5432L);
//        System.out.println(fetchedCreditCard);




