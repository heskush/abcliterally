package practice2019.coding.gfg.helper;

public class CompositeData {
    public int primary;
    public int secondary;

    CompositeData(int primary, int secondary) {
        this.primary = primary;
        this.secondary = secondary;
    }

    public static CompositeData[] generateList() {
        CompositeData a1 = new CompositeData(4, 2);
        CompositeData a2 = new CompositeData(4, 3);
        CompositeData a3 = new CompositeData(4, 5);
        CompositeData b1 = new CompositeData(1, 1);
        CompositeData b2 = new CompositeData(1, 2);
        CompositeData c = new CompositeData(2, 1);
        CompositeData d = new CompositeData(3, 1);
        CompositeData e = new CompositeData(5, 1);
        CompositeData[] data = {a1, e, b1, d, a2, c, a3, b2};
        return data;

    }

    @Override
    public String toString() {
        return String.format("(%d | %d)", primary, secondary);
    }
}
