public class p5 {
    public static void main(String[] args) {
        int[] a1 = {1,2,3};
        // int[] a2 = {1,2,3};
        int[] a2 = a1;
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));
        // As much as is reasonably practical, 
        // the hashCode method defined by class Object does return distinct integers for distinct objects. 
        // (This is typically implemented by converting the internal address of the object into an integer, 
        // but this implementation technique is not required by the JavaTM programming language.)

        // Make sure that you override both equals and hashcode not just one
    }
}
