package oncall.service;

public class IdxNameDTO {

    private int idx;
    private String name;

    public IdxNameDTO(int idx, String name) {
        this.idx = idx;
        this.name = name;
    }

    public int getIdx() {
        return idx;
    }

    public String getName() {
        return name;
    }
}
