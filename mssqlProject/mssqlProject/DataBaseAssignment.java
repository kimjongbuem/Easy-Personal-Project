package mssqlProject;

public class DataBaseAssignment {

	public static void main(String[] args) {
		MsSqlDAO mssqlDAO = new MsSqlDAO();
		System.out.println("������ �̸��� �����ּ��� : "); 
		String instructor_name = MsSqlDAO.scanner.nextLine();
		
		System.out.println("�������� ���� �Ͻ� �⵵�� �����ּ���! : "); 
		
		int year = MsSqlDAO.scanner.nextInt();
		
		mssqlDAO.printTotalCredit(instructor_name, year);
	}
}
