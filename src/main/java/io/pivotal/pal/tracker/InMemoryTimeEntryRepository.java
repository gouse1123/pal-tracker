package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private long id = 0;
    private List<TimeEntry> list = new ArrayList<>();

    @Override
    public TimeEntry find(long id) {

        TimeEntry timeEntry = list.stream()
                .filter(entry -> id == entry.getId())
                .findAny()
                .orElse(null);
        return timeEntry;
    }

    @Override
    public TimeEntry create(TimeEntry createTimeEntry) {
        createTimeEntry.setId(++id);
        list.add(createTimeEntry);
        return createTimeEntry;
    }

    @Override
    public List<TimeEntry> list() {
        return list;
    }

    @Override
    public TimeEntry update(long updateid, TimeEntry updateTimeEntry) {

        TimeEntry timeEntry = find(updateid);
        updateTimeEntry.setId(updateid);
        if(timeEntry != null){
            list.set(list.indexOf(timeEntry), updateTimeEntry);
            return updateTimeEntry;
        }
        return null;
    }

    @Override
    public void delete(long deleteid) {
        list.remove(find(deleteid));
    }

}
