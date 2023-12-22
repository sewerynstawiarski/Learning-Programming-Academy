import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        List<String> stringList = new ArrayList<>();
        stringList.add(String.format("'%s'", getName()));
        stringList.add(String.format("%d", getHitPoints()));
        stringList.add(String.format("%d", getStrength()));
        stringList.add(String.format("'%s'", getWeapon()));
        System.out.println(stringList);
        return stringList;
    }

    @Override
    public void read(List<String> list) {
        if (list != null && list.size() > 0) {
           this.name = list.get(0);
           this.hitPoints = Integer.parseInt(list.get(1));
           this.strength = Integer.parseInt(list.get(2));
           this.weapon = list.get(3);
        }
    }

    @Override
    public String toString() {
        System.out.println(String.format(getClass().getSimpleName() + "{name='%s', hitPoints=%d, strength=%d, weapon='%s'}", getName(), getHitPoints(), getStrength(), getWeapon()));
        return String.format(getClass().getSimpleName() + "{name='%s', hitPoints=%d, strength=%d, weapon='%s'}", getName(), getHitPoints(), getStrength(), getWeapon());
    }
}
