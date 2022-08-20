package io.mpj.lil.learningspring.business;

import io.mpj.lil.learningspring.data.Guest;
import io.mpj.lil.learningspring.data.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuests() {
        return this.guestRepository.findAll();
    }
}
