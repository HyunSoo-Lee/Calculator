package Cal;

import java.util.Scanner;

public class Main extends Functions {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		for(;;) {
			System.out.print("Enter the expression : ");
			String str = scan.nextLine();
			 if(check_matching(str) == 1)
				 System.out.println("수식의 괄호가 맞게 사용됨");
			 else {
				 System.out.println("수식의 괄호가 틀림");
				 break;
			 }
			 infix_to_postfix(str);
			break;
		}
	}
}


//[{C-(A+B)}+D]*E
//CAB+-D+E*