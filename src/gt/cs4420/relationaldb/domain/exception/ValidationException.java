package gt.cs4420.relationaldb.domain.exception;

import com.google.common.collect.Lists;

import java.util.List;

public class ValidationException extends Exception {

    private final List<String> messages;

    public ValidationException() {
        super();

        messages = Lists.newArrayList();
    }

    public ValidationException(final String message) {
        this();
        addMessage(message);
    }

    public void addMessage(final String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
