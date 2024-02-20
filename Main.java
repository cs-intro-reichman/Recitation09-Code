public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.printSize();
    }

    public static void printlog2firstElementsArray (int [] arr) {
        for (int i = 0; i < Math.log(arr.length); i++) {
            System.out.println(arr[i]);
        }
    }

    public static void print2DArr (int [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    public static void print3DArr (int [][][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.println(arr[i][j][k]);
                }
            }
        }
    }
}
