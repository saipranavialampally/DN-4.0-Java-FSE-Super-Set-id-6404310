package Handson5_TaskManagement;

class Task {
    int taskId;
    String taskName;
    String status;

    Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
    }
}

class TaskNode {
    Task task;
    TaskNode next;

    TaskNode(Task task) {
        this.task = task;
    }
}

public class TaskManager {
    static TaskNode head = null;

    static void addTask(Task task) {
        TaskNode node = new TaskNode(task);
        node.next = head;
        head = node;
    }

    static void deleteTask(int id) {
        if (head == null)
            return;
        if (head.task.taskId == id) {
            head = head.next;
            return;
        }

        TaskNode curr = head;
        while (curr.next != null && curr.next.task.taskId != id) {
            curr = curr.next;
        }
        if (curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    static Task searchTask(int id) {
        TaskNode curr = head;
        while (curr != null) {
            if (curr.task.taskId == id)
                return curr.task;
            curr = curr.next;
        }
        return null;
    }

    static void displayTasks() {
        TaskNode curr = head;
        while (curr != null) {
            System.out.println(curr.task.taskId + " " + curr.task.taskName + " - " + curr.task.status);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        addTask(new Task(1, "Design User Interface", "Pending"));
        addTask(new Task(2, "Write Backend code", "In Progress"));
        addTask(new Task(3, "Testing", "Not Started"));

        System.out.println("All Tasks:");
        displayTasks();

        deleteTask(3);
        System.out.println("\nAfter deleting Task 3:");
        displayTasks();
    }
}
