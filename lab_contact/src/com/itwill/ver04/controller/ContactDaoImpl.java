package com.itwill.ver04.controller;

import java.util.List;

import com.itwill.ver04.model.Contact;

// MVC 아키텍쳐에서 Controller 역할 담당 클래스. DAO(Data Access Object).
public class ContactDaoImpl implements ContactDao {

    @Override
    public int create(Contact contact) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Contact> read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Contact read(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(int index, Contact contact) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(int index) {
        // TODO Auto-generated method stub
        return 0;
    }

}
