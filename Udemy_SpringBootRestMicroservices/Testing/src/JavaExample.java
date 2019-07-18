public class JavaExample {

    public static void main(String[] args) {
        String str = "Hello";
        String reversed = reverseString(str);
        System.out.println("The reversed string is: " + reversed);
        //Second way
        //StringReverse obj = new StringReverse(); 
        //obj.reverse(str); 
    }

    public static String reverseString(String str)
    {
        if (str.isEmpty())
            return str;
        
        System.out.println("Substring : "+ str.substring(1) + "   Char : " + str.charAt(0));
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    //Second way
    void reverse(String str) 
    { 
        if ((str==null)||(str.length() <= 1)) 
           System.out.println(str); 
        else
        { 
            System.out.print(str.charAt(str.length()-1)); 
            reverse(str.substring(0,str.length()-1)); 
        } 
    } 
}