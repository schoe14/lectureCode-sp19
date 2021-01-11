public class flatten {
    public static int[] flatten(int[][] x) {
        int totalLength = 0;
        for(int[] element : x) {
            totalLength += element.length;
        }
        int[] a = new int[totalLength];
        int aIndex = 0;
        for (int[] element : x) {
            if (element.length > 0) {
                for (int num : element) {
                    a[aIndex] = num;
                    System.out.println(num);
                    aIndex++;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {}, {7, 8}};
        flatten(x);
    }
}
