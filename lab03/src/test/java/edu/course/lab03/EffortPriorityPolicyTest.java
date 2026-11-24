package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EffortPriorityPolicyTest {

    private final EffortPriorityPolicy policy = new EffortPriorityPolicy();

    @Test
    void returnsEstimatedHoursAsPriority() {
        ProjectTask task = new ProjectTask("TASK-1", "Task", 8);

        assertEquals(8, policy.calculatePriority(task));
    }

    @Test
    void givesMorePriorityToTaskWithMoreHours() {
        ProjectTask longTask = new ProjectTask("TASK-1", "Long task", 8);
        ProjectTask shortTask = new ProjectTask("TASK-2", "Short task", 3);

        assertTrue(policy.calculatePriority(longTask) > policy.calculatePriority(shortTask));
    }

    @Test
    void rejectsNullTask() {
        assertThrows(IllegalArgumentException.class, () -> policy.calculatePriority(null));
    }
}
