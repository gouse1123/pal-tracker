package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry find(long id);

    public TimeEntry create(TimeEntry createTimeEntry);

    public List<TimeEntry> list();

    public TimeEntry update(long id, TimeEntry updateTimeEntry);

    public void delete(long id);


}
