package view.message;

public interface LogMessage {
    String SELECT_ERROR = "Error executing select query";
    String UPDATE_ERROR = "Cannot execute update query";
    String PREPARE_STATEMENT_ERROR = "Cannot prepare statement";
    String CANT_CONNECT ="Cannot connect to the database";
}
