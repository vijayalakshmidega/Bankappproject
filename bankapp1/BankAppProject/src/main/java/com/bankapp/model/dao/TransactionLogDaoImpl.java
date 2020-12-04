package com.bankapp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TransactionLogDaoImpl implements TransactionLogDao{

private SessionFactory factory;
	
	@Autowired
	public TransactionLogDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	public  TransactionLog addTransaction(String txInfo, Double amount, TxType txType) {
		TransactionLog transactionEntry = new TransactionLog(txInfo, amount, txType);
		getSession().persist(transactionEntry);
		return transactionEntry;
	}
	@Override
	public List<TransactionLog> getTransactionLogFromAnAccount(int accountId) {
		Query query = getSession().createNativeQuery("select * from transaction_table t where t.account_id_fk=:accountId", TransactionLog.class);
		query.setParameter("accountId", accountId);
		List<TransactionLog> transactionEntries = query.getResultList();
		return transactionEntries;
		
	}
	


	

}
