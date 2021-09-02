package Cal;

import java.util.ArrayList;

public class Functions extends Basic_Stack_Functions{
	static int check_matching(String str) {
		Stacktype s;
		s = new Stacktype();
		
		char[] expression = new char[str.length()];
		 for (int i = 0; i < str.length(); i++) {
	            expression[i] = str.charAt(i);
	        }
		
		int ch, open_ch;
		int len = expression.length;
		init_stack(s);
		
		for(int i = 0; i < len; i++) {
			ch = expression[i];
			switch (ch) {
			case '(': case'[': case'{' :
				push(s,ch);
				break;
			case ')': case']': case'}' :
				if(is_empty(s)) return 0;
				else {
					open_ch = pop(s);
					if ((open_ch == '(' && ch != ')') ||
						(open_ch == '[' && ch != ']') ||
						(open_ch == '{' && ch != '}')) {
						return 0;
					}
					break;
				}
			}
		}
		if(!is_empty(s))
			return 0;
		
		return 1;
	}
	
	static int prec(int op) {
		switch(op) {
		case'(': case')': case'{': case'}': case'[': case']': return 0;
		case'+': case'-': return 1;
		case'*': case'/': case'^': return 2;
		}
		return -1;
	}
	
	static void infix_to_postfix(String str, ArrayList<Integer>postfix) {
		Stacktype s;
		s = new Stacktype();
		
		char[] expression = new char[str.length()];
		 for (int i = 0; i < str.length(); i++) {
	            expression[i] = str.charAt(i);
	        }
		
		int ch, top_op;
		int len = expression.length;
		init_stack(s);
		
		for(int i = 0; i<len; i++) {
			ch = expression[i];
			switch(ch) {
			case'+': case'-': case'*': case'/': case'^':
				while(!is_empty(s) && (prec(ch) <= prec(peek(s))))
					//System.out.printf("%c", pop(s));
					postfix.add(pop(s));
				push(s, ch);
				break;
			case'(': 
				push(s,ch);
				break;
			case')':
				top_op = pop(s);
				while(top_op != '(') {
					//System.out.printf("%c",  top_op);
					postfix.add(top_op);
					top_op = pop(s);
				}
				break;
			case'{':
				push(s,ch);
				break;
			case'}':
				top_op = pop(s);
				while(top_op != '{') {
					//System.out.printf("%c",  top_op);
					postfix.add(top_op);
					top_op = pop(s);
				}
				break;
			case'[': 
				push(s,ch);
				break;
			case']':
				top_op = pop(s);
				while(top_op != '[') {
					//System.out.printf("%c",  top_op);
					postfix.add(top_op);
					top_op = pop(s);
				}
				break;
			default:
				do{
					postfix.add(ch);
					ch = expression[++i];
				} while (ch >= 0 && ch <= 9);
				postfix.add((int) ' ');
				i--;
				break;
			}
		}
		while(!is_empty(s)) {
			System.out.printf("%c", pop(s));
		}
	}
}
