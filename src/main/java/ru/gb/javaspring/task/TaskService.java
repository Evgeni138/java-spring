package ru.gb.javaspring.task;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getALLTasks() {
        return tasks;
    }

    public Task getTaskById(UUID uuid) {
        return tasks.stream().filter(it -> it.getId().equals(uuid)).findFirst().orElse(null);
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public void deleteTask(UUID uuid) {
        tasks.removeIf(it -> it.getId().equals(uuid));
    }

    public Task update(UUID uuid, Task task) {
        Task task1 = getTaskById(uuid);
        if (task1 != null) {
            task1.setName(task.getName());
            task1.setCompletionTime(task.getCompletionTime());
            task1.setDescription(task.getDescription());
            task1.setStatus(task.getStatus());
        }

        return task1;
    }
}
