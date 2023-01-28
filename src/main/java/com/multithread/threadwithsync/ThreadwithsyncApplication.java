package com.multithread.threadwithsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadwithsyncApplication {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Bank bank= new Bank(1000);
		Runnable depositAmt = ()->{
		  for(int i=0;i<1000;i++){
			  bank.deposit(100,i);
		  }
		};
		Runnable withdrawnAmt = ()->{
			for(int i=0;i<1000;i++){
				bank.withDrawn(50,i);
			}
		};
       executor.submit(depositAmt);
	   executor.submit(withdrawnAmt);
	   executor.shutdown();
	}

}
