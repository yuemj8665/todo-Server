package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {

    private String title;
    private Long order;
    private boolean completed;

    public boolean isCompleted() {
        return completed;
    }

    public TodoRequest setCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }
}
