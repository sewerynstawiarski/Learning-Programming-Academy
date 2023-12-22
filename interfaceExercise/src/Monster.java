import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int hitPoints;
    private int strength;
    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public String toString() {
        return String.format(getClass().getSimpleName() + "{name='%s', hitPoints=%d, strength=%d}", getName(), getHitPoints(), getStrength());
    }

    @Override
    public List<String> write() {
        List<String> stringList = new ArrayList<>();
        stringList.add(String.format("%s", getName()));
        stringList.add(String.format("%d", getHitPoints()));
        stringList.add(String.format("%d", getStrength()));
        System.out.println(stringList);
        return stringList;
    }

    @Override
    public void read(List<String> list) {
        if (list != null && list.size() > 0) {
            this.name = list.get(0);
            this.hitPoints = Integer.parseInt(list.get(1));
            this.strength = Integer.parseInt(list.get(2));
        }
    }
}
