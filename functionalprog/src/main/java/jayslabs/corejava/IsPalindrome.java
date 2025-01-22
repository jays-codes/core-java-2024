package jayslabs.corejava;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println("Is 'madam' a palindrome? " + isPalindrome("madam"));
        System.out.println("Is 'hello' a palindrome? " + isPalindrome("hello"));
    }

    public static boolean isPalindrome(String str){
        
        int strlen = str.length();

        for (int i=0;i<strlen/2;i++){
            if (str.charAt(i) != str.charAt(strlen-i-1)){
                return false;
            }
        }
        return true;
    }
}
