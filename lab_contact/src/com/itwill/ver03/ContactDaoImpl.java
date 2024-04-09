package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;

// controller 클래스
public class ContactDaoImpl implements ContactDao {
    //----- singleton
    private static ContactDaoImpl instance = null;
    
    private ContactDaoImpl() {}
    
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        
        return instance;
    }
    //----- singleton

    private List<Contact> contacts = new ArrayList<>();
    
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < contacts.size());
    }
    
    @Override
    public int create(Contact contact) {
        try {
            contacts.add(contact);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Contact> read() {
        return contacts;
    }

    @Override
    public Contact read(int index) {
        if (isValidIndex(index)) {
            return contacts.get(index);
        } else {
            return null;
        }
    }

    @Override
    public int update(int index, Contact contact) {
        if (isValidIndex(index)) {
            contacts.set(index, contact);
//            contacts.get(index).setName(contact.getName());
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int delete(int index) {
        if (isValidIndex(index)) {
            contacts.remove(index);
            return 1;
        } else {
            return 0;
        }
    }

}
