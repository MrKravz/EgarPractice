package services.impl;

import models.*;
import repositories.*;
import services.ComputeTimeService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

class ComputeTimeServiceImpl implements ComputeTimeService {

    private final EmployeeRepository employeeRepository;
    private final TimeSheetRepository timeSheetRepository;
    private int totalTime = 0;

    public ComputeTimeServiceImpl(EmployeeRepository employeeRepository, TimeSheetRepository timeSheetRepository) {
        this.employeeRepository = employeeRepository;
        this.timeSheetRepository = timeSheetRepository;
    }

    @Override
    public int computeTime(UUID employeeId, TimeStatus timeStatus, Date dateStart, Date dateEnd) {
        var employee = employeeRepository.findEmployeeById(employeeId);
        if (employee.isEmpty()) {
            throw new RuntimeException();
        }
        List<TimeSheet> timeSheets = timeSheetRepository.findAllByDateAndEmployee(employee.get(),dateStart, dateEnd)
                .stream()
                .filter(x -> x.getTimeStatus().equals(timeStatus))
                .toList();
        for (var timeSheet : timeSheets) {
            totalTime += timeSheet.getTimeSpan();
        }
        return totalTime;
    }

}
