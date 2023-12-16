package oncall.service;

public class IdxNameDTO {

    private final int idx;
    private final String name;

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
