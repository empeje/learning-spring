package io.mpj.lil.learningspring.util;

import io.mpj.lil.learningspring.data.Guest;
import io.mpj.lil.learningspring.data.Room;
import io.mpj.lil.learningspring.data.RoomRepository;
import io.mpj.lil.learningspring.data.GuestRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = roomRepository.findAll();
        rooms.forEach(System.out::println);

        Iterable<Guest> guest = guestRepository.findAll();
        guest.forEach(System.out::println);
    }
}
