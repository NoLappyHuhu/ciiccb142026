package chapter3;
public class StringBuilderLesson{
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("abc");
        StringBuilder b= a.append("de");
        b.append("f").append("g");
        System.out.println("a = "+a);
        System.out.println("b = "+b);

        StringBuilder sb = new StringBuilder("Programming");
        sb.setLength(4);
        System.out.println(sb);
    }
}