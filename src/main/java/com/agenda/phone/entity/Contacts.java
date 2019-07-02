package com.agenda.phone.entity;

import javax.persistence.*;

@Entity
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Number_phone")
    private String numberPhone;

    public void updateContacts(ContactsDTO contactsDTO) {
        this.id = contactsDTO.getId();
        this.firstName = contactsDTO.getFirstName();
        this.lastName = contactsDTO.getLastName();
        this.numberPhone = contactsDTO.getNumberPhone();
    }

    public ContactsDTO toContactsDTO() {
        ContactsDTO contactsDTO = new ContactsDTO();

        contactsDTO.setId(this.id);
        contactsDTO.setFirstName(this.getFirstName());
        contactsDTO.setLastName(this.getLastName());
        contactsDTO.setNumberPhone(this.getNumberPhone());

        return contactsDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
