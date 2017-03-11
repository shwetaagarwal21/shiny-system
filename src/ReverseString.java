import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class ReverseString {

	public static void main(String[] args) {
		ReverseString rev = new ReverseString();
		String str = "Alive is awesome";
		rev.reverseString1(str);
		System.out.println();
		rev.reverseString2(str);
		System.out.println();
		rev.reverseString3(str);
		System.out.println();
		rev.reverseString4(str);
		System.out.println();
		rev.reverseString5(str);
		System.out.println();
		String strRev = rev.reverseStringRec(str);
		System.out.println(strRev);

	}
	
	void reverseString1(String str){
		char[] chrArray = str.toCharArray();
		for(int i=chrArray.length-1;i>=0;i--){
			System.out.print(chrArray[i]);
		}
	}
	
	void reverseString2(String str){
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(str);
		strBuilder = strBuilder.reverse();
		System.out.print(strBuilder.toString());
	}
	
	void reverseString3(String str){
		char[] tempArray = str.toCharArray();
		int left, right = 0;
		right = tempArray.length - 1;
		for(left = 0; left < right; left++, right--){
			char temp = tempArray[left];
			tempArray[left] = tempArray[right];
			tempArray[right] = temp;
		}
		System.out.print(tempArray);
	}
	
	void reverseString4(String str){
		char[] temp = str.toCharArray();
		List<Character> llist = new LinkedList<>();
		for(char ch : temp){
			llist.add(ch);
		}
		Collections.reverse(llist);
		ListIterator lItr = llist.listIterator();
		while(lItr.hasNext()){
			System.out.print(lItr.next());
		}
	}
	
	void reverseString5(String str){
		byte [] strAsByteArray = str.getBytes();
		byte [] result = new byte [strAsByteArray.length];
		   
		for(int i = 0; i<strAsByteArray.length; i++){
			result[i] = strAsByteArray[strAsByteArray.length-i-1];
		}
		System.out.print(new String(result));
	}
	
	String reverseStringRec(String str){
		if(str.length() == 0)
		{
			return "";
		}
		return str.substring(str.length()-1) + reverseStringRec(str.substring(0,str.length()-1));
	}
	
}
