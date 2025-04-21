public class Main {

    public static void main (String [] args) {
        System.out.println("testing");
        String s = "this is a test string";
        Main testClass = new Main();
        testClass.testPrint(s);
    }

    private void testPrint (String s) {
        System.out.println(s);
    }

}
