
public class StringAbbreviation {

	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buffer = new StringBuffer();
		buffer.append(str.substring(0, 1));
		int length = str.length();
		
		String end = str.substring(length - 1, length);
		str = str.substring(1, length - 1);
		System.out.println("String is :: " + str);
		int lengthMiddle = str.length();
		System.out.println("lengthMiddle :: " + lengthMiddle);
		buffer.append(lengthMiddle);
		buffer.append(end);
		System.out.println(buffer.toString());
		//buffer.append(str.substring(length - 1, length));

	}

}
