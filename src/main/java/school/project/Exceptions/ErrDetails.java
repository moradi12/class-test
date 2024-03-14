package school.project.Exceptions;

public enum ErrDetails {
    STUDENT_NOT_FOUND("Student Id not found in our database");

    private String msg;

    ErrDetails(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
