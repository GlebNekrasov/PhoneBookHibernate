package ru.academits.nekrasovgleb.converter;

import org.springframework.stereotype.Service;
import ru.academits.nekrasovgleb.dto.ContactDto;
import ru.academits.nekrasovgleb.model.Contact;

@Service
public class ContactToContactDtoConverter extends AbstractConverter<Contact, ContactDto> {
    @Override
    public ContactDto convert(Contact source) {
        ContactDto c = new ContactDto();

        c.setId(source.getId());
        c.setFirstName(source.getFirstName());
        c.setLastName(source.getLastName());
        c.setPhone(source.getPhone());

        return c;
    }
}
