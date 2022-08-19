package io.mpj.lil.learningspring.util;

import io.mpj.lil.learningspring.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservation;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservation) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservation = reservation;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = roomRepository.findAll();
        rooms.forEach(System.out::println);

        Iterable<Guest> guest = guestRepository.findAll();
        guest.forEach(System.out::println);

        Iterable<Reservation> reservations = reservation.findAll();
        reservations.forEach(System.out::println);
    }
}
