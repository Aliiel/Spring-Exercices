package com.insy2s.Spring_Exercices.Controllers;

import com.insy2s.Spring_Exercices.Entities.Booking;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final ArrayList<Booking> bookings = new ArrayList<>();
    private int currentId = bookings.size();

    @PostMapping
    public ResponseEntity<String> postBooking(@RequestBody Booking booking){
        booking.setId(++currentId);
        bookings.add(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body("Réservation confirmée avec l'ID " + (booking.getId()));
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> putBooking(@PathVariable int id, @RequestBody Booking updatedBooking){

        for (Booking booking : bookings) {

            if (booking.getId() == id) {

                booking.setDate(updatedBooking.getDate());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Booking updated");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id){

        for (Booking booking : bookings) {

            if (booking.getId() == id) {

                bookings.remove(booking);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Booking deleted");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return ResponseEntity.ok(bookings);
    }
}
