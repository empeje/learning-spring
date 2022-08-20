package io.mpj.lil.learningspring.util;

import io.mpj.lil.learningspring.business.ReservationService;
import io.mpj.lil.learningspring.business.RoomReservation;
import io.mpj.lil.learningspring.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private final RoomRepository roomRepository;
    @Autowired
    private final GuestRepository guestRepository;
    @Autowired
    private final ReservationRepository reservation;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private DateUtils dateUtils;

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

        Iterable<Reservation> res1 = reservation.findReservationByResDate(reservation.findAll().get(0).getResDate());
        res1.forEach(System.out::println);

        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> ress = this.reservationService.getRoomReservationsForDate(date);
        ress.forEach(System.out::println);
    }
}
