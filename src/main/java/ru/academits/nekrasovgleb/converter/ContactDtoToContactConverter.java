package ru.academits.nekrasovgleb.converter;

import org.springframework.stereotype.Service;
import ru.academits.nekrasovgleb.dto.ContactDto;
import ru.academits.nekrasovgleb.model.Contact;

@Service
public class ContactDtoToContactConverter extends AbstractConverter<ContactDto, Contact> {
    @Override
    public Contact convert(ContactDto source) {
        Contact c = new Contact();

        c.setId(source.getId());
        c.setFirstName(source.getFirstName());
        c.setLastName(source.getLastName());
        c.setPhone(source.getPhone());
        c.setIsRemoved(false);

        return c;
    }
}
