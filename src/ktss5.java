import java.util.Scanner;
import java.util.regex.Pattern;

public class ktss5 {
    public static void main(String[] args) {
        int choice;
        String [] list = new String[100];
        int size = 0;
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^B\\d{7}$");
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Hien thi danh sach MSSV");
            System.out.println("2. Them moi MSSV");
            System.out.println("3. Cap nhat MSSV");
            System.out.println("4. Xoa MSSV");
            System.out.println("5. Tim kiem MSSV");
            System.out.println("0. Thoat");
            System.out.print("Lua chon cua ban: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    if (size == 0) {
                        System.out.println("Danh sach rong!");
                        break;
                    }
                    for (int i = 0; i < size; i++) {
                        System.out.println(i + " : " + list[i]);
                    }
                    break;
                case 2:
                    if (size >= 100) {
                        System.out.println("Mang da day!");
                        break;
                    }
                    String mssv;
                    while (true) {
                        System.out.print("Nhap MSSV: ");
                        mssv = sc.nextLine();
                        if (pattern.matcher(mssv).matches())
                            break;
                        System.out.println("MSSV sai dinh dang! Vi du: B2101234");
                    }
                    list[size++] = mssv;
                    System.out.println("Them thanh cong!");
                    break;
                case 3:
                    System.out.print("Nhap index can sua: ");
                    int index = Integer.parseInt(sc.nextLine());
                    if (index < 0 || index >= size) {
                        System.out.println("Index khong hop le!");
                        break;
                    }
                    String mssvnew;
                    while (true) {
                        System.out.print("Nhap MSSV moi: ");
                        mssvnew = sc.nextLine();
                        if (pattern.matcher(mssvnew).matches())
                            break;
                        System.out.println("Sai dinh dang!");
                    }
                    list[index] = mssvnew;
                    System.out.println("Cap nhat thanh cong!");
                    break;
                case 4:
                    System.out.print("Nhap MSSV can xoa: ");
                    String x = sc.nextLine();
                    int pos = -1;
                    for (int i = 0; i < size; i++) {
                        if (list[i].equalsIgnoreCase(x)) {
                            pos = i;
                            break;
                        }
                    }
                    if (pos == -1) {
                        System.out.println("Khong tim thay MSSV!");
                        break;
                    }
                    for (int i = pos; i < size - 1; i++) {
                        list[i] = list[i + 1];
                    }
                    size--;
                    System.out.println("Xoa thanh cong MSSV!");
                    break;
                case 5:
                    System.out.print("Nhap MSSV can tim: ");
                    String key = sc.nextLine().toLowerCase();
                    boolean found = false;
                    for (int i = 0; i < size; i++) {
                        if (list[i].toLowerCase().contains(key)) {
                            System.out.println(i + " : " + list[i]);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Khong co MSSV phu hop!");
                    }
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!!");
                    break;
            }

        } while (choice != 0);
    }
}
