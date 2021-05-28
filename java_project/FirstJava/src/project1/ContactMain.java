package project1;

public class ContactMain {
    public static void main(String[] args) {
        Contact contact = new Contact("김용민", "010020200",
                "naver", "서울", 0304, "백수");
        System.out.println(contact.getName());
        System.out.println(contact.getBirth());
        contact.showContactInfo();

        contact.setName("김용순");
        System.out.println(contact.getName());
        System.out.println(contact.getBirth());
        contact.showContactInfo();
    }
}
