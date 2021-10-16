package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.MakeDao;
import dao.ModelDao;
import entity.Make;
import entity.Model;

public class Menu {
	
	private ModelDao modelDao = new ModelDao();
	private MakeDao makeDao = new MakeDao();
	private Scanner scanner = new Scanner(System.in);
	public List<String> options = Arrays.asList("Display Vehicle Makers",
		 "Display A Make",
		 "Display Models",
		 "Create Vehicle Maker ",
		 "Delete Vehicle Maker",
		 "Create Model For Maker",
		 "Delete Model By Maker"
			);
	
	public void start() {
		String select = "";
		
	  do {
		  printMenu();
		  select = scanner.nextLine();
	  try {
		  if (select.equals("1")) {
			 displayVehicleMakers();
		  } else if (select.equals("2")) {
			 displayMaker();
		  } else if (select.equals("3")) {
			 displayModels();
		  }else if (select.equals("4")) {
			  createVehicleMaker();
		  }else if (select.equals("5")) {
			  deleteVehicleMaker();
		  }else if (select.equals("6")) {
			  createModel();
		  }else if (select.equals("7")) {
			  deleteModel();
		  }
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }
		  
		  System.out.println("\nPress enter to continue......");
		  scanner.nextLine();
	  } while(!select.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n-----------------------");
		for(int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ")" + options.get(i));
		}
	}
	
	private void displayVehicleMakers() throws SQLException {
		List<Make> makes = makeDao.getmake();
		for (Make make : makes) {
			System.out.println(make.getMakeId() + ": " + make.getName());
		}
	}
	private void displayMaker() throws SQLException {
		System.out.println("Enter Maker Id: ");
		int id = Integer.parseInt(scanner.nextLine());
	    Make make = makeDao.getMakeById(id);
	    System.out.println(make.getMakeId() + ":" + make.getName());			
	}
	private void displayModels() throws SQLException {
		List<Model> models = modelDao.getModelById(); 
			for(Model model: models) {
				System.out.println(model.getModelId() + ":" + model.getName() + "," + model.getYear());
			}
		}
	private void createVehicleMaker() throws SQLException {
		System.out.println("Enter new Vehicle maker name:");
		String makeName = scanner.nextLine();
		makeDao.createNewMaker(makeName);
	}
	
	private void deleteVehicleMaker() throws SQLException {
		System.out.println("Enter Vehicle Maker ID to Delete:");
		int ID = Integer.parseInt(scanner.nextLine());
	    makeDao.deleteMakerById(ID);
	}
	
	private void createModel() throws SQLException {
		System.out.println("Enter new Model name:");
		String modelName = scanner.nextLine();
		modelDao.createModel(modelName);
	}
	
	private void deleteModel() throws SQLException {
		System.out.println("Enter Model ID to Delete");
		int ID = Integer.parseInt(scanner.nextLine());
		modelDao.deleteModelById(ID);
	}
		
	

  
}
