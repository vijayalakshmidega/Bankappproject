package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.dao.TransactionLog;
import com.bankapp.model.dao.TxType;

public interface TransactionLogService {

	
	public List<TransactionLog> getTransactionLogFromAnAccount(int accountId);
}
