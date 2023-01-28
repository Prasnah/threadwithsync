package com.multithread.threadwithsync;

import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private double balance;
    private final ReentrantLock reentrantLock = new ReentrantLock();

    public Bank(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount, int member) {
        reentrantLock.lock();
        try {
            this.balance += amount;
            System.out.println("Deposited: " + amount + ", new balance: " + balance + " by thread " + Thread.currentThread().getName() + " for member " + member);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void withDrawn(double amount, int member) {
        reentrantLock.lock();
        try {
            this.balance -= amount;
        } finally  {
            reentrantLock.unlock();
        }
        System.out.println("Withdrawn: " + amount + ", new balance: " + balance + " by thread " + Thread.currentThread().getName() + " for member " + member);
    }
}
