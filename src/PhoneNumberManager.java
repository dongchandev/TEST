import java.util.Scanner;

public class PhoneNumberManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        while (true) {
            System.out.println("1. 저장하기");
            System.out.println("2. 목록 출력하기");
            System.out.println("3. 이름으로 검색하기");
            System.out.println("4. 프로그램 종료하기");
            System.out.println("5. 목록 내보내기");
            System.out.println("6. 삭제하기");

            System.out.print("번호 입력: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    contactManager.saveContact(scanner);
                    break;
                case 2:
                    contactManager.printContactList();
                    break;
                case 3:
                    contactManager.searchByName(scanner);
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다...");
                    scanner.close();
                    System.exit(0);
                case 5:
                    contactManager.exportToFile();
                    break;
                case 6:
                    contactManager.deleteContact(scanner);
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }
}
