package pl.akademiaqa.context;

import lombok.Data;
import pl.akademiaqa.dto.BugDto;
import pl.akademiaqa.dto.EmployeeDto;
import pl.akademiaqa.handlers.bug.BugResponse;
import pl.akademiaqa.handlers.employee.EmployeeResponse;

import java.util.ArrayList;
import java.util.List;

@Data
public class Context {

    private EmployeeResponse employeeResponse;
    private BugResponse bugResponse;
    private EmployeeDto employee;
    private BugDto bug;
    private List<EmployeeResponse> employeeResponseList = new ArrayList<>();
    private List<EmployeeDto> employeeDtoList = new ArrayList<>();
    private List<BugResponse> bugResponseList = new ArrayList<>();
    private List<BugDto> bugDtoList = new ArrayList<>();

    public void addEmployeeToList(EmployeeDto employeeDto) {employeeDtoList.add(employeeDto);}

    public void addEmployeeResponseToList(EmployeeResponse employeeResponse) {
        employeeResponseList.add(employeeResponse);
    }

    public void addBugToList(BugDto bugDto) {
        bugDtoList.add(bugDto);
    }

    public void addBugResponseToList(BugResponse bugResponse) {
        bugResponseList.add(bugResponse);
    }
}
