package pl.akademiaqa.api.employee;

import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.BaseRequest;
import pl.akademiaqa.dto.EmployeeDto;
import pl.akademiaqa.handlers.employee.CreateEmployeeResponse;
import pl.akademiaqa.handlers.employee.EmployeeResponse;
import pl.akademiaqa.url.JsonServerUrl;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class UpdateEmployeeRequest {

    private final BaseRequest baseRequest;

    public EmployeeResponse updateEmployee(EmployeeDto employee, int employeeId) {

        return given()
                .spec(baseRequest.requestSetup())
                .body(employee)
                .when()
                // delete(JsonServerUrl.getEmployeePath(employeeId))
                .put(JsonServerUrl.EMPLOYEES + employeeId)
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response()
                .as(CreateEmployeeResponse.class);
    }
}
