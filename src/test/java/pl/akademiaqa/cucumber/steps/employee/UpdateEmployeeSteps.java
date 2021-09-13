package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.employee.UpdateEmployeeRequest;
import pl.akademiaqa.context.Context;
import pl.akademiaqa.dto.EmployeeDto;
import pl.akademiaqa.handlers.employee.EmployeeResponse;

@RequiredArgsConstructor
public class UpdateEmployeeSteps {

    private final UpdateEmployeeRequest updateEmployeeRequest;
    private final Context context;

    @When("I update employee email")
    public void i_update_employee_email() {
        int employeeId = context.getEmployeeResponse().getId();

        EmployeeDto updateEmployee = context.getEmployee();
        updateEmployee.setEmail("jblack@akademiaqa.com");
        updateEmployee.setWebsite("www.akademiaqa.com");
        updateEmployee.setUsername("JoeBlack");

        EmployeeResponse response = updateEmployeeRequest.updateEmployee(updateEmployee, employeeId);

        Assertions.assertThat(response.getEmail()).isEqualTo(updateEmployee.getEmail());
        Assertions.assertThat(response.getUsername()).isEqualTo(updateEmployee.getUsername());
        Assertions.assertThat(response.getWebsite()).isEqualTo(updateEmployee.getWebsite());
    }
}
