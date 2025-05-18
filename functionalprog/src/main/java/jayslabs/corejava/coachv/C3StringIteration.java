package jayslabs.corejava.coachv;


public class C3StringIteration {

    final static String str = "HW0r1d!!! 1t's me J4y!!!";

    public static void main(String[] args) {

        // str.chars().forEach(ch -> {
        //     System.out.println((char) ch);
        // });

        // str.chars().mapToObj(ch -> Character.valueOf((char) ch))
        // .forEach(System.out::println);

        str.chars().filter(ch -> Character.isDigit(ch))
        .forEach(IterateString::printChar);
    }
       



}

class IterateString {
  public static void printChar(int aChar) {
    System.out.println((char)(aChar));
  }
}
