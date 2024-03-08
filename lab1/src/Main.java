import java.util.Scanner;

public class Main extends Operations {
    public static void main(String[] args) {
        System.out.println("*********  Welcome to this note-making app ***********");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("1. INSERT");
            System.out.println("2. UPDATE");
            System.out.println("3. DELETE");
            System.out.println("4. SHOW TABLE");
            System.out.println("5. EXIT");
            System.out.println();
            int opt = sc.nextInt();
            sc.nextLine();

            if (opt == 1) {
                System.out.println("Enter Title");
                String title = sc.nextLine();
                System.out.println("Enter Description");
                String desc = sc.nextLine();
                insert(title, desc);
            } else if (opt == 2) {
                System.out.println("Enter what you want to update");
                String updateVal = sc.nextLine();

                System.out.println("Enter value");
                String value = sc.nextLine();
                System.out.println("Enter id");
                int id = sc.nextInt();
                update(updateVal, value, id);
            } else if (opt == 3) {
                System.out.println("Enter id whom you want to delete");
                int id = sc.nextInt();
                delete(id);
            } else if (opt == 4) {
                showTable();
            }else if(opt ==5){
                break;
            }
        }
    }
}
