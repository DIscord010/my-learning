package club.csiqu.patterns.principle.demeter;

/**
 * 总公司员工
 */
class Employee {

    private String id;

    void setId(String id) {
        this.id = id;
    }

    String getId() {
        return id;
    }
}