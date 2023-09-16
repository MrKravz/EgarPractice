package services;

import models.Total;

import java.util.Date;
import java.util.UUID;

public interface ComputeTotalService {

    Total computeTotal(UUID employeeId, Date dateStart, Date dateEnd);

}
