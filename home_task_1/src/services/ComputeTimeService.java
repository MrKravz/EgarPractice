package services;

import models.TimeStatus;

import java.util.Date;
import java.util.UUID;

public interface ComputeTimeService {

    int computeTime(UUID employeeId, TimeStatus timeStatus, Date dateStart, Date dateEnd);

}
