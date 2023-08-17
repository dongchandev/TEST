import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private List<Contact> contactList = new ArrayList<>();

    public void saveContact(Scanner scanner) {
        System.out.print("이름 입력: ");
        String name = scanner.nextLine();
        System.out.print("전화번호 입력: ");
        String phoneNumber = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber);
        if (!contactList.contains(newContact)) {
            contactList.add(newContact);
            System.out.println("전화번호가 저장되었습니다.");
        } else {
            System.out.println("동일한 전화번호가 이미 저장되어 있습니다.");
        }    }

    public void printContactList() {
        System.out.println("현재 등록된 데이터 개수: " + contactList.size() + "개");
        Collections.sort(contactList);
        for (Contact contact : contactList) {
            System.out.println(contact);
        }    }

    public void searchByName(Scanner scanner) {
        System.out.print("검색할 이름: ");
        String searchName = scanner.nextLine();

        List<Contact> searchResults = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getName().contains(searchName)) {
                searchResults.add(contact);
            }
        }

        System.out.println("검색 결과 개수: " + searchResults.size() + "개");
        Collections.sort(searchResults);
        for (Contact contact : searchResults) {
            System.out.println(contact);
        }    }

    public void exportToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("contact_list.txt"))) {
            Collections.sort(contactList);
            for (Contact contact : contactList) {
                writer.println(contact);
            }
            System.out.println("전화번호 목록이 파일로 내보내졌습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //기능추가 : 전화번호 삭제
    public void deleteContact(Scanner scanner) {
        System.out.print("삭제할 이름: ");
        String deleteName = scanner.nextLine();

        Contact contactToRemove = null;
        for (Contact contact : contactList) {
            if (contact.getName().equals(deleteName)) {
                contactToRemove = contact;
                break;
            }
        }

        if (contactToRemove != null) {
            contactList.remove(contactToRemove);
            System.out.println(deleteName + "의 연락처가 삭제되었습니다.");
            updateFile(); // 파일 업데이트 호출
        } else {
            System.out.println(deleteName + "의 연락처를 찾을 수 없습니다.");
        }
    }

    private void updateFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("contact_list.txt"))) {
            Collections.sort(contactList);
            for (Contact contact : contactList) {
                writer.println(contact);
            }
            System.out.println("전화번호 목록이 파일로 업데이트되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}