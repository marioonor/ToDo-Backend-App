package todo.todoapp;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import todo.todoapp.repository.TodoRepository;
import todo.todoapp.todoentity.TodoEntity;

@SpringBootApplication
public class TodoappApplication implements CommandLineRunner {

	@Autowired
	TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n\nWelcome to the Todo Application!");
		System.out.println("\nPlease enter your name:");
		String name = scanner.nextLine();

		System.out.println("\nHello, " + name + "! Let's get started with your todo list.\n");

		boolean running = true;
		while (running) {

			System.out.println("\nPlease select activity you want to perform:");
			System.out.println("1. Show");
			System.out.println("2. Add");
			System.out.println("3. Edit");
			System.out.println("4. Delete");
			System.out.println("5. Exit");

			System.out.println("\nPlease enter your choice:");
			String choice = scanner.nextLine();

			switch (choice) {
				case "Show":
					System.out.println("\n\nHere are your todo items:\n");
					for (TodoEntity todoEntities : todoRepository.findAll()) {
						System.out.println("Title: " + todoEntities.getTitle());
						System.out.println("Description: " + todoEntities.getDescription());
						System.out.println("Status: " + todoEntities.getStatus());
						System.out.println("--------------------------------------------------------------------");
						System.out.println("\n");
					}
					break;

				case "Add":
					System.out.println("\nPlease enter the number of todo items you want to add:");
					int numberOfItems = scanner.nextInt();
					scanner.nextLine();

					for (int i = 0; i < numberOfItems; i++) {
						System.out.println("\nPlease enter the \"Title\" of todo item (" + (i + 1) + "):");
						String title = scanner.nextLine();
						System.out.println("\nPlease enter the \"Description\" of todo item " + (i + 1) + ":");
						String description = scanner.nextLine();
						System.out.println("\nPlease enter the \"Status\" of todo item " + (i + 1) + ":");
						String status = scanner.nextLine();

						TodoEntity todoEntity = new TodoEntity();
						todoEntity.setTitle(title);
						todoEntity.setDescription(description);
						todoEntity.setStatus(status);
						todoRepository.save(todoEntity);
					}
					System.out.println("\n\nYour todo items have been saved successfully!\n\n");
					break;

				case "Edit":
					System.out.println("\nYou have selected to Edit a todo item.");
					System.out.println("\nPlease enter the \"Title\" of todo item you want to edit:");
					String editTitle = scanner.nextLine();
					System.out.println("\nPlease enter the \"Description\" of todo item you want to edit:");
					String editDescription = scanner.nextLine();
					System.out.println("\nPlease enter the \"Status\" of todo item you want to edit:");
					String editStatus = scanner.nextLine();
					System.out.println("\nPlease enter the \"ID\" of todo item you want to edit:");
					Long editId = scanner.nextLong();

					TodoEntity todoEntity = new TodoEntity();
					todoEntity.setId(editId);
					todoEntity.setTitle(editTitle);
					todoEntity.setDescription(editDescription);
					todoEntity.setStatus(editStatus);
					todoRepository.save(todoEntity);
					System.out.println("\n\nYour todo item has been updated successfully!\n\n");
					break;

				case "Delete":
					System.out.println("\nYou have selected to Delete a todo item.");
					System.out.println("\nPlease enter the \"ID\" of todo item you want to delete:");
					Long deleteId = scanner.nextLong();

					TodoEntity todoEntity1 = new TodoEntity();
					todoEntity1.setId(deleteId);
					todoEntity1.setTitle(" ");
					todoEntity1.setDescription(" ");
					todoEntity1.setStatus(" ");
					todoRepository.deleteById(deleteId);
					System.out.println("\n\nYour todo item has been deleted successfully!\n\n");
					break;

				case "Exit":
					System.out.println("\n\n\nThank you for using the Todo Application!");
					System.out.println("Goodbye, " + name + "!");
					System.out.println("Have a great day!");
					running = false;
					return;

				default:
					System.out.println("\nInvalid choice. Please try again.");
					break;
			}

		}
		scanner.close();

	}

}
