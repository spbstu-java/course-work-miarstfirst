package Lab2;

public class Test {

    public String methPublic1 () {
        return "call methPublic1";
    }

    @TestAnnotation
    public String methPublic2 (String msg, String msg2) {
        return  "methPublic2 annotated but not called with ..." + msg + "... and ..." + msg2 + "...";
    }

    @TestAnnotation
    protected String methProtected1 (int value) {
        return "call methProtected1 with" + value + " value";
    }
    protected String methProtected2 () {
        return "call methProtected2";
    }

    @TestAnnotation(5)
    private String methPrivate1 (double value, int v2) {
        return "call methPrivate1 with " + value + " double value and int " + v2;
    }
    private String methPrivate2 () {
        return "call methPrivate2";
    }

}
