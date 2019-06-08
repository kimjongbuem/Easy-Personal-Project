package mssqlProject;

public class DataBaseAssignment {

	public static void main(String[] args) {
		MsSqlDAO mssqlDAO = new MsSqlDAO();
		System.out.println("교수님 이름을 적어주세요 : "); 
		String instructor_name = MsSqlDAO.scanner.nextLine();
		
		System.out.println("교수님이 강의 하신 년도를 적어주세요! : "); 
		
		int year = MsSqlDAO.scanner.nextInt();
		
		mssqlDAO.printTotalCredit(instructor_name, year);
	}
}
