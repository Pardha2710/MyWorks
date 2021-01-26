package com.bank.service;

public class AccountService {
	public static int balance=50000;
	public int deposit(int amount)
	{
		balance=balance+amount;
		return balance;
	}
	public int withdraw(int amount)
	{
		balance=balance-amount;
		return balance;
	}
}
