package util;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class QueryList <T extends Student & QueryItem> {
    private ArrayList<T> items;
    public QueryList(ArrayList<T> items) {
        this.items = items;
    }
    public static <S extends QueryItem> List<S> getMatches(List<S>items,  String field, String value) {
        List<S> matches = new ArrayList<>();
        for (var item :
                items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
    public List<T> getMatches(String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item :
                items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
