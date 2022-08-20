package io.mpj.lil.learningspring.webservice;

import io.mpj.lil.learningspring.business.GuestService;
import io.mpj.lil.learningspring.business.ReservationService;
import io.mpj.lil.learningspring.business.RoomReservation;
import io.mpj.lil.learningspring.data.Guest;
import io.mpj.lil.learningspring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;
    private final GuestService guestService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService, GuestService guestService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
        this.guestService = guestService;
    }

    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(
            @RequestParam(value = "date", required = false) String dateString) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping("/guests")
    public List<Guest> getGuests() {
        return this.guestService.getAllGuests();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public Guest createGuest(@RequestBody Guest payload) {
        return this.guestService.createGuest(payload);
    }
}
