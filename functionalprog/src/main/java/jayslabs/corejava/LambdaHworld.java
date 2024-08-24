package jayslabs.corejava;

interface Ilambda{
    void lambda();
}

public class LambdaHworld {
    public static void main(String[] args) {
        Ilambda lambda = () -> System.out.println("Yeaaaaoooowww!!! HWorld !!!");
        lambda.lambda();
    }
}
