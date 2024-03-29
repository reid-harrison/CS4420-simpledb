package gt.cs4420.relationaldb.domain.exception;

import com.google.common.collect.Lists;

import java.util.Collection;
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

    public ValidationException(final Collection<String> messages) {
        this();
        addMessages(messages);
    }

    public void addMessage(final String message) {
        messages.add(message);
    }

    public void addMessages(final Collection<String> messages) {
        this.messages.addAll(messages);
    }

    public List<String> getMessages() {
        return messages;
    }

    public boolean hasMessages() {
        return !messages.isEmpty();
    }

    public void addException(final ValidationException ve) {
        addMessages(ve.getMessages());
    }

    public String getMessage() {
        StringBuilder message = new StringBuilder();

        for (String m : messages) {
            message.append(" // ");
            message.append(m);
        }

        return message.toString();
    }

}
