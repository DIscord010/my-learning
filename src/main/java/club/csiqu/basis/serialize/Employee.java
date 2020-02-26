package club.csiqu.basis.serialize;

import java.io.Serializable;

class Employee implements Serializable {

    private static final long serialVersionUID = -9190522432983174450L;

    public String name;

    private String address;

    private int SSN;

    private int number;

    Employee(String name, String address, int SSN, int number) {
        this.name = name;
        this.address = address;
        this.SSN = SSN;
        this.number = number;
    }

    void Check() {
        System.out.println(name + "\n" + address + "\n" + SSN + "\n" + number);
    }
}