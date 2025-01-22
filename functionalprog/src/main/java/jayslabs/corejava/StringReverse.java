package jayslabs.corejava;

public class StringReverse {

    public static void main(String[] args) {
        System.out.println("Reverse of 'Hello' is: " + reverse("Hello"));
    }

    public static String reverse(String str){
        String output = "";

        for (int i=str.length()-1;i>=0;i--){
            output = output + str.charAt(i);
        }

        return output;
    }
}
