package Cal;

import java.util.Scanner;

public class Main extends Functions {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		for(;;) {
			System.out.print("Enter the expression : ");
			String str = scan.nextLine();
			 if(check_matching(str) == 1)
				 System.out.println("������ ��ȣ�� �°� ����");
			 else {
				 System.out.println("������ ��ȣ�� Ʋ��");
				 break;
			 }
			 infix_to_postfix(str);
			break;
		}
	}
}


//[{C-(A+B)}+D]*E
//CAB+-D+E*