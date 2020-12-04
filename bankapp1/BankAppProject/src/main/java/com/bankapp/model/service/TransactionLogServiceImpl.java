package com.bankapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bankapp.model.dao.TransactionLog;
import com.bankapp.model.dao.TransactionLogDao;


@Service("transactionService")
@Transactional
public class TransactionLogServiceImpl implements TransactionLogService{
	private TransactionLogDao transactionlogdao;
	
  
	public List<TransactionLog> getTransactionLogFromAnAccount(int accountId) {
		
		return transactionlogdao.getTransactionLogFromAnAccount(accountId);
	}

}
