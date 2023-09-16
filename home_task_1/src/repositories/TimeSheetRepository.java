package repositories;

import models.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TimeSheetRepository {

    public List<TimeStatus> findDistinctTimeStatuses() {
        return Collections.emptyList();
    }

    public List<TimeSheet> findAllByDateAndEmployee(Employee employee, Date dateStart, Date dateEnd) {
        return Collections.emptyList();
    }

}
