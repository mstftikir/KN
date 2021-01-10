package com.kn.contactlist.repository;

import com.kn.contactlist.model.ContactTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactTable, Long> {
}