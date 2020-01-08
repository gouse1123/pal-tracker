package io.pivotal.pal.tracker;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTimeEntryRepository implements TimeEntryRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JdbcTimeEntryRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public TimeEntry find(long id) {
        return null;
    }

    @Override
    public TimeEntry create(TimeEntry createTimeEntry) {

        String insertQuery = "INSERT INTO time_entries (project_id, user_id, date, hours) " +
                "VALUES (" + createTimeEntry.getProjectId() + ", " +
                createTimeEntry.getUserId() + ", " +
                createTimeEntry.getDate() + ", " +
                createTimeEntry.getHours() + ")";

        int result = jdbcTemplate.update(insertQuery);

        return result ==1 ? createTimeEntry : null;
    }

    @Override
    public List<TimeEntry> list() {
        return null;
    }

    @Override
    public TimeEntry update(long id, TimeEntry updateTimeEntry) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
