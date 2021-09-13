package pl.akademiaqa.handlers.bug;

import lombok.Data;

@Data
public abstract class BugResponse {

    protected int id;
    protected String title;
    protected String description;
    protected int employeeId;
    protected String status;
}
