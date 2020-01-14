package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository = PalTrackerApplication.getRepo();

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public @ResponseBody ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry){
        return new ResponseEntity<TimeEntry>(timeEntryRepository.create(timeEntry), HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public @ResponseBody ResponseEntity<TimeEntry> read(@PathVariable("id") long id){
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if(timeEntry != null)
            return new ResponseEntity<TimeEntry>(timeEntry,HttpStatus.OK);
        else
            return new ResponseEntity<>(timeEntry, HttpStatus.NOT_FOUND);

    }

    @GetMapping("/time-entries")
    public @ResponseBody ResponseEntity<List<TimeEntry>> list(){
        List<TimeEntry> list = timeEntryRepository.list();
        return new ResponseEntity<List<TimeEntry>>(list, HttpStatus.OK);
    }

    @PutMapping("/time-entries/{id}")
    public @ResponseBody ResponseEntity<TimeEntry> update(@PathVariable("id") long id, @RequestBody TimeEntry timeEntry){
        TimeEntry updatedTimeEntry = timeEntryRepository.update(id, timeEntry);
        if(updatedTimeEntry != null)
            return new ResponseEntity<TimeEntry>(updatedTimeEntry,HttpStatus.OK);
        else
            return new ResponseEntity<>(updatedTimeEntry, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/time-entries/{id}")
    public @ResponseBody ResponseEntity<String> delete(@PathVariable("id") long id){
        timeEntryRepository.delete(id);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }


}
