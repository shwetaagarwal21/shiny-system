
public class Max5InArray {

	public static void main(String[] args) {
		int i;
		int large[] = new int[5];
		int array[] = {33, 55, 13, 46, 87, 41, 10, 34, 43, 56};
		int max = 0, index;
		for(int j=0;j<5;j++){
			max = array[j];
			index = j;
			for(i = 0;i<array.length;i++){
				if(max<array[i]){
					max = array[i];
					index = i;
				}
			}
			large[j] = max;
			array[index] = Integer.MIN_VALUE;
			
			System.out.println("Largest " +j + " : " + large[j]);
		}
		System.out.println();
		Max5InArray obj = new Max5InArray();
		obj.getNumber("Shweta 8 SAgar 5 is a soft 6 engin 1 eer.4");
	}
	
	
	public void getNumber (String line) {
        
        System.out.println("Your string '" + line + "' is being parsed now.....");
        int length = line.length();
        for(int i = 0;i < length; i++){
        	Character ch = line.charAt(i);
        	if(Character.isDigit(ch)){
        		System.out.print("Character " + ch + " is a number ");
        		if (ch%2 == 0) {
    				System.out.println("and it is even!");
    			}
    			else {
    				System.out.println("and it is odd!");
    			}
        	}
        }
        /*char c[] = line.toCharArray();
        for(int i=0;i<c.length;i++){
        	System.out.println();
        	if(c[i] >=0 && c[i] < 9){
        		System.out.println("Character " + c[i] + " is a number");
        		if (c[i]%2==0) {
    				System.out.println("and it is even!");
    			}
    			else {
    				System.out.println("and it is odd!");
    			}
        	}
        	
        }*/
        //char c;
        /*for (int i=0; i='0' && c<='9') {
			System.out.println("Character " + c + " is a number");
			if (c%2==0) {
				System.out.println("and it is even!");
			}
			else {
				System.out.println("and it is odd!");
			}
        }
		else if (c==' ') {
			System.out.println("Character " + c + " is a blank");
		}
		else {
			System.out.println("Character " + c + " is a letter");
		}*/
    }

}
