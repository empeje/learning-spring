package io.mpj.lil.learningspring.webservice;

import io.mpj.lil.learningspring.business.GuestService;
import io.mpj.lil.learningspring.business.ReservationService;
import io.mpj.lil.learningspring.business.RoomReservation;
import io.mpj.lil.learningspring.util.DateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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
}
