public class Main {
    public static void main(String[] args) {

        System.out.println(square(0,6,3));
    }
    public static int square(int a, int b,int c){
        int halfPerimeter = (a*b*c)/2;
        double triangleSquare = Math.sqrt(halfPerimeter*(halfPerimeter-a)*(halfPerimeter-b)*(halfPerimeter-c));
        return (int) triangleSquare;


    }
}