package hellojpa;

import hellojpa.prac2.Address;

public class ValueMain {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;

        Address address1 = new Address("Gunpo", "sanbon", "15802");
        Address address2 = new Address("Gunpo", "sanbon", "15802");

        System.out.println("a == b : " + (a == b));
        System.out.println("address1 == address2  :" + (address1 == address2));
        System.out.println("address1  equals address2  :" + (address1.equals(address2)));
    }
}
