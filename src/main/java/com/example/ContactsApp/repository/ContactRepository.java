package com.example.ContactsApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ContactsApp.domain.Contact;
 
 
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
 
}