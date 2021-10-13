package com.javapractice;

import javapractice.EmployeePayrollData;
import javapractice.EmployeePayrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static javapractice.EmployeePayrollService.IOService.DB_IO;

public class EmployeePayrollServiceTest {
    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData =
                employeePayrollService.readEmployeePayrollData(DB_IO);
        Assertions.assertEquals(3, employeePayrollData.size());
    }
}
