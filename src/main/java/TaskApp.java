import java.util.Scanner;

import br.com.mariojp.easytask.Task;
import br.com.mariojp.easytask.TaskManager;

public class TaskApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nGerenciador de Tarefas:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Completar Tarefa");
            System.out.println("3. Remover Tarefa");
            System.out.println("4. Listar Tarefas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    completeTask();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    listTasks();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Nome da Tarefa: ");
        String name = scanner.nextLine();
        Task task = new Task(name);
        taskManager.addTask(task);
        System.out.println("Tarefa adicionada com sucesso.");
    }

    private static void completeTask() {
        System.out.print("Nome da Tarefa a completar: ");
        String name = scanner.nextLine();
        taskManager.completeTask(name);
        System.out.println("Tarefa completada.");
    }

    private static void removeTask() {
        System.out.print("Nome da Tarefa a remover: ");
        String name = scanner.nextLine();
        taskManager.removeTask(name);
        System.out.println("Tarefa removida.");
    }

    private static void listTasks() {
        System.out.println("Tarefas:");
        for (Task task : taskManager.getTasks()) {
            System.out.println(task);
        }
    }
}