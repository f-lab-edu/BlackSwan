package com.dsg.wardstudy.controller.reservation;

import com.dsg.wardstudy.domain.reservation.Reservation;
import com.dsg.wardstudy.dto.reservation.ReservationDetail;
import com.dsg.wardstudy.dto.reservation.ReservationRequest;
import com.dsg.wardstudy.service.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reservation")
    public ResponseEntity<ReservationDetail> create(@RequestBody ReservationRequest reservationRequest) {
        log.info("reservation create");
        return new ResponseEntity<>(reservationService.create(reservationRequest), HttpStatus.CREATED);
    }

    @GetMapping("/reservation/{reservationId}")
    public ResponseEntity<ReservationDetail> getById(@PathVariable("reservationId") Long reservationId) {
        log.info("reservation getById");
        return ResponseEntity.ok(reservationService.getById(reservationId));
    }

    @GetMapping("/reservation")
    public ResponseEntity<List<ReservationDetail>> getAll() {
        log.info("reservation getAll");
        return ResponseEntity.ok(reservationService.getAll());
    }

    @PutMapping("/reservation/{reservationId}")
    public Long updateById(@PathVariable("reservationId") Long reservationId,
                           @RequestBody ReservationRequest reservationRequest){
        log.info("reservation updateById");
        return reservationService.updateById(reservationId, reservationRequest);
    }

    @DeleteMapping("/reservation/{reservationId}")
    public ResponseEntity<String> deleteById(@PathVariable("reservationId") Long reservationId) {
        log.info("reservation deleteById");
        reservationService.deleteById(reservationId);
        return new ResponseEntity<>("a reservation successfully deleted!", HttpStatus.OK);
    }


}
