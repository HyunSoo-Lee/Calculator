package Cal;

public class Basic_Stack_Functions extends Stacktype{
	static void init_stack(Stacktype s) {
		s.top = -1;
	}
	
	static boolean is_empty(Stacktype s) {
		return(s.top == -1);
	}
	
	static boolean is_full(Stacktype s) {
		return(s.top == (max_stack_size - 1));
	}
	
	static void push(Stacktype s, int item) {
		if(is_full(s)) {
			System.out.print("스택 포화 에러\n");
			return;
		}
		else 
			s.data[++(s.top)] = item;				
	}
	
	static int pop(Stacktype s) {
		if(is_full(s)) {
			System.out.print("스택 포화 에러\n");
			return 0;
		}
		else return s.data[(s.top)--];			
	}
	
	static int peek(Stacktype s) {
		if(is_empty(s)) {
			System.out.print("스택 포화 에러\n");
			return 0;
		}
		else return s.data[s.top];
	}
}
