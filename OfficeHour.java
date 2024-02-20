public class OfficeHour {
    public static void main(String[] args) {
        double pow = Math.pow(2, 3); // function 
        String test = "Hello world";
        String test1 = "Office";
        System.out.println(test.charAt(0) == test1.charAt(0)); // charAt


        int [] arr = {-4,5,0};
        test(Math.abs(arr[0]));
        System.out.println(arr[0]);
        
    }
    public static void e1 () {
        int [] a = {10,20,30}; 
        int [] b = a;
        b[1] = 7;
        System.out.println(a[1]);
        System.out.println(b[1]);
        int c = 65;
        int d = c;
        d = 7;
        System.out.println(c);
    }

    public static int test (int a) {
        return Math.abs(a);
    }
}
