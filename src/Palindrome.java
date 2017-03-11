
class Palindrome
{
   public static void main(String args[])
   {
      String original, reverse = "";
      original = "madam";
      int length = original.length();
 
      for ( int i = length - 1; i >= 0; i-- )
         reverse = reverse + original.charAt(i);
      
      if (original.equals(reverse))
         System.out.println("Entered string is a palindrome.");
      else
         System.out.println("Entered string is not a palindrome.");
      
      boolean flag = checkPalindrome(original);
      System.out.println("      " + flag);
 
   }
   
   static boolean  checkPalindrome(String original){
	   int length = original.length();
	   int i, begin, mid, end;
	   begin = 0;
	   end = length - 1;
	   mid = (begin+end)/2;
	   for (i = begin; i <= mid; i++) {
		   if (original.charAt(begin) == original.charAt(end)) {
			   begin++;
			   end--;
		   }
		   else {
			   break;
		   }
	   }
	   if (i == mid + 1)
		   return true;
	   else
		   return false;
	   
   }
}


