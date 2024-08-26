public class Approach {
    public static void generateGrayCode(int n, int bit, String str) {
        if (n == 1) {
            System.err.println(str + bit);
            bit = bit == 1 ? 0 : 1;
            System.err.println(str + bit);
            return;
        }
        generateGrayCode(n - 1, 0, str + bit);
        bit = bit == 1 ? 0 : 1;
        generateGrayCode(n - 1, 1, str + bit);
    }

    public static void main(String[] args) {
        generateGrayCode(4, 0, "");
    }
}