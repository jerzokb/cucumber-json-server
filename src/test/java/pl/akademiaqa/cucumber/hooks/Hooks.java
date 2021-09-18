package pl.akademiaqa.cucumber.hooks;

import io.cucumber.java.After;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import pl.akademiaqa.api.bug.DeleteBugRequest;
import pl.akademiaqa.api.employee.DeleteEmployeeRequest;
import pl.akademiaqa.context.Context;
import pl.akademiaqa.handlers.bug.BugResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class Hooks {

    private final Context context;
    private final DeleteEmployeeRequest deleteEmployeeRequest;
    private final DeleteBugRequest deleteBugRequest;

    @After(value = "@cleanup_employee")
    public void afterEmployeeManagementScenario() {
        int employeeId = context.getEmployeeResponse().getId();
        deleteEmployeeRequest.deleteEmployee(employeeId);
    }

    @After(value = "@cleanup_bug")
    public void afterBugManagementScenario() {
        int bugId = context.getBugResponse().getId();
        deleteBugRequest.deleteBug(bugId);
    }

    @After(value = "@cleanup_bugs")
    public void afterBugsManagementScenario() {
        List<BugResponse> bugs = context.getBugResponseList();
        for (BugResponse bug : bugs) {
            int bugId = bug.getId();
            deleteBugRequest.deleteBug(bugId);
        }
    }
}
