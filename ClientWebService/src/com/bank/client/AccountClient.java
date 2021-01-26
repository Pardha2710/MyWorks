package com.bank.client;

import org.apache.axis2.AxisFault;

import com.bank.service.AccountServiceStub;
import com.bank.service.AccountServiceStub.Deposit;
import com.bank.service.AccountServiceStub.DepositResponse;

public class AccountClient {

	public static void main(String[] args) throws Exception {
		AccountServiceStub stub=new AccountServiceStub();
		Deposit deposit=new Deposit();
		deposit.setAmount(15000);
		DepositResponse response=stub.deposit(deposit); 
		System.out.println("Current Balance="+response.get_return());

	}

}
