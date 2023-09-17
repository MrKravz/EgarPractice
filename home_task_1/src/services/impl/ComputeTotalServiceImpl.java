package services.impl;

import models.*;
import repositories.*;
import services.*;

import java.util.Date;
import java.util.UUID;

public class ComputeTotalServiceImpl implements ComputeTotalService {

    private final ComputeSalaryService computeSalaryService;
    private final ComputeTimeService computeTimeService;
    private final EmployeeRepository employeeRepository;
    private final TimeSheetRepository timeSheetRepository;
    private int totalSalary = 0;

    public ComputeTotalServiceImpl(ComputeSalaryService computeSalaryService, ComputeTimeService computeTimeService,
                                   EmployeeRepository employeeRepository, TimeSheetRepository timeSheetRepository) {
        this.computeSalaryService = computeSalaryService;
        this.computeTimeService = computeTimeService;
        this.employeeRepository = employeeRepository;
        this.timeSheetRepository = timeSheetRepository;
    }

    @Override
    public Total computeTotal(UUID employeeId, Date dateStart, Date dateEnd) {
        Total total = new Total();
        var employee = employeeRepository.findEmployeeById(employeeId);
        if (employee.isEmpty()) {
            throw new RuntimeException();
        }
        var timeStatuses = timeSheetRepository.findDistinctTimeStatuses();
        for (var timeStatus : timeStatuses) {
            var timeSpan = computeTotalTime(total, timeStatus, employeeId, dateStart, dateEnd);
            computeTotalSalary(employee.get().getRate(), timeSpan, timeStatus);
        }
        total.setTotalSalary(totalSalary);
        total.setEmployee(employee.get());
        total.setDate(new Date(System.currentTimeMillis()));
        return total;
    }

    private int computeTotalTime(Total total, TimeStatus timeStatus, UUID id,  Date dateStart, Date dateEnd) {
        if (timeStatus.equals(TimeStatus.Turnout)) {
            total.setTotalTurnoutTime(computeTimeService.computeTime(id, timeStatus,dateStart, dateEnd));
            return total.getTotalTurnoutTime();
        }
        if (timeStatus.equals(TimeStatus.OverTime)) {
            total.setTotalOverTime(computeTimeService.computeTime(id, timeStatus, dateStart, dateEnd));
            return total.getTotalOverTime();
        }
        if (timeStatus.equals(TimeStatus.BusinessTrip)) {
            total.setTotalBusinessTripTime(computeTimeService.computeTime(id,timeStatus, dateStart, dateEnd));
            return total.getTotalBusinessTripTime();
        }
        if (timeStatus.equals(TimeStatus.Vacation)) {
            total.setTotalVacationTime(computeTimeService.computeTime(id,timeStatus, dateStart, dateEnd));
            return total.getTotalVacationTime();
        }
        if (timeStatus.equals(TimeStatus.SickDays)) {
            total.setTotalSickDaysTime(computeTimeService.computeTime(id,timeStatus, dateStart, dateEnd));
            return total.getTotalSickDaysTime();
        }
        total.setTotalAbsenceTime(computeTimeService.computeTime(id,timeStatus, dateStart, dateEnd));
        return total.getTotalAbsenceTime();
    }

    private void computeTotalSalary(Rate rate, int time, TimeStatus timeStatus) {
        totalSalary += computeSalaryService.computeHoursSalary(rate, time, timeStatus);
    }

}
