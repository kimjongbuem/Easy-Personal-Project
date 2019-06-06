package mssqlProject;

public class DataBaseAssignment {

	public static void main(String[] args) {
		MsSqlDAO mssqlDAO = new MsSqlDAO();
		System.out.println("새로 개설할 학과 이름을 넣어주세요 ! : "); 
		String dept_name = MsSqlDAO.scanner.nextLine();
		
		System.out.println("건물 이름을 넣어주세요 ! : "); 
		String building = MsSqlDAO.scanner.nextLine();
		
		System.out.println("새로 개설할 학과의 예산을 넣어주세요 ! : "); 
		double burget = MsSqlDAO.scanner.nextDouble();
		MsSqlDAO.scanner.nextLine();
		
		mssqlDAO.addNewDepartment(dept_name, building, burget);
	}
}
