package mssqlProject;

public class DataBaseAssignment {

	public static void main(String[] args) {
		MsSqlDAO mssqlDAO = new MsSqlDAO();
		System.out.println("���� ������ �а� �̸��� �־��ּ��� ! : "); 
		String dept_name = MsSqlDAO.scanner.nextLine();
		
		System.out.println("�ǹ� �̸��� �־��ּ��� ! : "); 
		String building = MsSqlDAO.scanner.nextLine();
		
		System.out.println("���� ������ �а��� ������ �־��ּ��� ! : "); 
		double burget = MsSqlDAO.scanner.nextDouble();
		MsSqlDAO.scanner.nextLine();
		
		mssqlDAO.addNewDepartment(dept_name, building, burget);
	}
}
