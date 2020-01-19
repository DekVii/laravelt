package com.dekvii.LARAVELT.DAO;

import com.dekvii.LARAVELT.Model.Account;

import java.util.ArrayList;
import java.util.List;


public class AccountDAO {
    private List<Account> list = new ArrayList<>();

    public AccountDAO() {
        list.add(new Account("Opik", "083145910665",
                "Sleman, DIY"));
    }

    public void insert(Account account) {
        list.add(account);
    }

    public void update(int id, Account account) {
        Account old = list.get(id);
        old.setName(account.getName());
        old.setContact(account.getContact());
        old.setAddress(account.getAddress());
    }

    public void delete(int id) {
        list.remove(id);
    }

    public Account select(int id) {
        return list.get(id);
    }

    public List<Account> selectAll() {
        return list;
    }
}
