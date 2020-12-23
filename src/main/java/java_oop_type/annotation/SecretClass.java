package java_oop_type.annotation;

public class SecretClass {
	@PublicCall(value = 10)
    private int privateAnnotatedIntMethod() {
        System.out.println("privateAnnotatedIntMethod call");
        return 1;
    }

    private void notAnnotatedMethod() {
        System.out.println("Not annotated method call");
    }

    @PublicCall(value = 2)
    private void annotatedMethod() {
        System.out.println("annotatedMethod call");
    }

    @PublicCall
    private String anotherAnnotatedMethod() {
        System.out.println("anotherAnnotatedMethod call");
        return "qwe";
    }

    public void test(){
        System.out.println("test");
    }
}
