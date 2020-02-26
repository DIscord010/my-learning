package club.csiqu.patterns.principle.demeter;

/**
 * 分公司员工
 */
class SubEmployee {

    private String id;

    void setId(String id) {
        this.id = id;
    }

    String getId() {
        return id;
    }
}