package view;
import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addACar() {
			// TODO Auto-generated method stub
			System.out.print("Enter Car make: ");
			String make = in.nextLine();
			System.out.print("Enter Car model: ");
			String model = in.nextLine();
			System.out.print("Enter Car year: ");
			String year = in.nextLine();
			/*send ListItem object to the method to persist*/
			ListItem toAdd = new ListItem(make, model,year);
			/*put the item in the database*/
			lih.insertCar(toAdd);

		}

		private static void deleteACar() {
			// TODO Auto-generated method stub
			System.out.print("Enter the make to delete: ");
			String make = in.nextLine();
			System.out.print("Enter the model to delete: ");
			String model = in.nextLine();
			System.out.print("Enter the year to delete: ");
			String year = in.nextLine();
			ListItem toDelete = new ListItem(make, model, year);
			
			lih.deleteCar(toDelete);

		}

		private static void editACar() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Car Make");
			System.out.println("2 : Search by Car Model");
			System.out.println("3 : Search by Car Year");
			int searchBy = in.nextInt();
			in.nextLine();
//			List<ListItem> foundItems = null;
			List<ListItem> foundItems;

			if (searchBy == 1) {
				System.out.print("Enter the Car Make: ");
				String makeName = in.nextLine();
				foundItems = lih.searchForCarByMake(makeName);
			} else if (searchBy == 2) {
				System.out.print("Enter the Car Model: ");
				String modelName = in.nextLine();
				foundItems = lih.searchForCarByModel(modelName);

			} else {
				System.out.print("Enter the Car Year: ");
				String yearName = in.nextLine();
				foundItems = lih.searchForCarByYear(yearName);

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForCarById(idToEdit);
				System.out.println("Retrieved "+ toEdit.getMake() + " " + toEdit.getModel() + " " + toEdit.getYear());
				System.out.println("1 : Update Make");
				System.out.println("2 : Update Model");
				System.out.println("3 : Update Year");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Car Make: ");
					String newMake = in.nextLine();
					toEdit.setMake(newMake);
				} else if (update == 2) {
					System.out.print("New Car Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				} else {
					System.out.println("New Car Year: ");
					String newYear = in.nextLine();
					toEdit.setYear(newYear);
				}

				lih.updateCar(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome Car shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an option:");
				System.out.println("*  1 -- Add a Car");
				System.out.println("*  2 -- Edit a Car");
				System.out.println("*  3 -- Delete a Car");
				System.out.println("*  4 -- View the Car list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addACar();
				} else if (selection == 2) {
					editACar();
				} else if (selection == 3) {
					deleteACar();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListItem> allCars = lih.showAllCars();
			for(ListItem l : allCars){
				System.out.println(l.returnItemDetails());
			//	System.out.println(l.toString());
			}		

		}

	}