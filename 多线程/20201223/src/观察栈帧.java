public class 观察栈帧 {
    private static void a1(){

    }
    private static void b1(){
        a1();
    }
    private static void c1(){
        b1();
    }
    private static void d1(){
        c1();
    }
    private static void e1(){
        d1();
    }

    public static void main(String[] args) {
        e1();
    }
}
