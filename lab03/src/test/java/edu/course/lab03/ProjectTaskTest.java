package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProjectTaskTest {

    @Test
    void constructorCreatesTaskWithNewStatus() {
        ProjectTask task = new ProjectTask("TASK-1", "Task", 8);

        assertEquals("TASK-1", task.getId());
        assertEquals("Task", task.getTitle());
        assertEquals(TaskStatus.NEW, task.getStatus());
        assertEquals(8, task.getEstimatedHours());
    }

    @Test
    void constructorRejectsInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask(null, "Task", 8));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("", "Task", 8));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("   ", "Task", 8));
    }

    @Test
    void constructorRejectsInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", null, 8));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", "", 8));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", "   ", 8));
    }

    @Test
    void constructorRejectsNonPositiveEstimatedHours() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", "Task", 0));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("TASK-1", "Task", -1));
    }

    @Test
    void changeStatusUpdatesStatus() {
        ProjectTask task = new ProjectTask("TASK-1", "Task", 8);

        task.changeStatus(TaskStatus.IN_PROGRESS);

        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }

    @Test
    void changeStatusRejectsNull() {
        ProjectTask task = new ProjectTask("TASK-1", "Task", 8);

        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
        assertEquals(TaskStatus.NEW, task.getStatus());
    }
}
