package co.com.poli.serviceshowtimes.controller;


import co.com.poli.serviceshowtimes.entities.ShowTime;
import co.com.poli.serviceshowtimes.services.ShowTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtime")
@RequiredArgsConstructor
public class ShowTimesController {
    private final ShowTimeService showTimeService;

    @PostMapping
    public ResponseEntity<ShowTime> save(@RequestBody ShowTime showTime){
        showTimeService.save(showTime);
        return ResponseEntity.ok(showTime);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ShowTime> delete(@PathVariable("id") Long id){
        ShowTime showTime = showTimeService.findById(id);
        if(showTime == null){
            return ResponseEntity.notFound().build();
        }
        showTimeService.delete(showTime);
        return ResponseEntity.ok(showTime);
    }

    @GetMapping
    public ResponseEntity<List<ShowTime>> findAll(){
        List<ShowTime> showTimes = showTimeService.findAll();
        if (showTimes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(showTimes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowTime> findById(@PathVariable("id") Long id){
        ShowTime showTime = showTimeService.findById(id);
        if (showTime == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(showTime);
    }
}
