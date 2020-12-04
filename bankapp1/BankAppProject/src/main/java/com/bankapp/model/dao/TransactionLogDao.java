package com.bankapp.model.dao;
import java.util.*;
public interface TransactionLogDao {

	public  TransactionLog addTransaction(String txInfo, Double amount, TxType txType);
	public List<TransactionLog> getTransactionLogFromAnAccount(int accountId);
	
	
}
