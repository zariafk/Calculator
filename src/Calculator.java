import java.util.Scanner;


public class Calculator {
    
    public static void main(String[] args) {
        boolean running  = true;
        while (running) {
            Scanner keyboard = new Scanner(System.in);

            float a;
            float b;
            String c;

            print("Enter a number: ");
            a = Float.parseFloat(keyboard.nextLine());

            print("Enter another number: ");
            b = Float.parseFloat(keyboard.nextLine());

            print("a) add    b) subtract     c) multiply     d) divide?");
            c = (keyboard.nextLine());

            try {
                compute(a, b, c);
            } catch (Exception e) {
                print("Invalid input.");
            }
        }

    }

    public static <T> void print(T x) {
        System.out.println(x);
    }

    public static void add(float x, float y) {
        float ans = x+y;
        print(ans);
    }

    public static void subtract(float x, float y){
        float ans = x-y;
        print(ans);
    }

    public static void multiply(float x, float y){
        float ans = x*y;
        print(ans);
    }

    public static void divide(float x, float y){
        float ans = x/y;
        print(ans);
    }

    public static void compute(float x, float y, String s){
        if (s.equals("a")){
            add(x, y);
        }

        else if (s.equals("b")){
            subtract(x, y);
        }

        else if (s.equals("c")){
            multiply(x, y);
        }

        else if (s.equals("d")){
            divide(x, y);
        }

        else {
            print("Invalid input.");
        }
    }
}