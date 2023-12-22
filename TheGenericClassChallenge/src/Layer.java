import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {
    private List<T> elements;

    public Layer(T[] elements) {
        this.elements = new ArrayList<T>(List.of(elements));
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }
    public void renderLayer() {
        for (var element :
                elements) {
            System.out.println(element.render());
        }
    }
    public void addElements (T... elements) {
        this.elements.addAll(List.of(elements));
    }
}
