package com.agenda.phone.implementation;

import com.agenda.phone.entity.Contacts;
import com.agenda.phone.entity.ContactsDTO;
import com.agenda.phone.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders= "*")
public class ContactsMethod {

    @Autowired
    private ContactsRepository contactsRepository;

/*
* Added test
* */
    @GetMapping("/getallcontacts")
    public List<Contacts> getAllContacts() {
        return new ArrayList<>(contactsRepository.findAll());
    }

    @GetMapping("/getonecontact/{id}")
    public ContactsDTO getOneContact(@PathVariable Long id){
        return contactsRepository.findById(id).get().toContactsDTO();
    }

    @PostMapping("/addnewcontact")
    public ContactsDTO addNewContact(@RequestBody ContactsDTO contactsDTO) {
        Contacts contacts = new Contacts();
        contacts.updateContacts(contactsDTO);
        return contactsRepository.save(contacts).toContactsDTO();
    }

    @PutMapping("/editcontact/{id}")
    public ContactsDTO editContact(@RequestBody ContactsDTO contactsDTO, @PathVariable Long id){
        Optional<Contacts> getContactDb = contactsRepository.findById(id);

        if(getContactDb.isPresent()){
            Contacts contacts = getContactDb.get();

            contacts.setFirstName(contactsDTO.getFirstName());
            contacts.setLastName(contactsDTO.getLastName());
            contacts.setNumberPhone(contactsDTO.getNumberPhone());
            return contactsRepository.save(contacts).toContactsDTO();
        } else {
            return  null;
        }

    }

    @CrossOrigin("*")
    @DeleteMapping("/deletecontact/{id}")
	public ContactsDTO deleteContact(@PathVariable Long id) {
    	contactsRepository.deleteById( id );
    	return null;
    }

}
