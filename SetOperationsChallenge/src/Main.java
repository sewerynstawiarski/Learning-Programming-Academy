import javax.sound.midi.Track;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All tasks", tasks);


        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's tasks", annsTasks, sortByPriority);
        Set<Task> bobsTasks = TaskData.getTasks("Bob");

        Set<Task> carolsTasks = TaskData.getTasks("Carol");

        Set<Task> unionSet = getUnion(List.of(tasks, annsTasks, bobsTasks, carolsTasks));
        sortAndPrint("Union set of tasks", unionSet);

        Set<Task>  assignedTasks = getUnion(List.of(annsTasks, bobsTasks, carolsTasks));
        sortAndPrint("Tasks that was assigned", assignedTasks, sortByPriority);

        Set<Task> missingTasks = getDifference(unionSet, tasks);
        sortAndPrint("Missing Tasks", missingTasks);

        Set<Task> unassignedTasks = getDifference(tasks, assignedTasks);
        sortAndPrint("Unassigned Tasks", unassignedTasks, sortByPriority);

        Set<Task> intersectionAllAnn = getIntersected(annsTasks, unionSet);
        sortAndPrint("intersection of Ann and All", intersectionAllAnn);

        Set<Task> intersectionAnnBob = getIntersected(annsTasks, bobsTasks);
        sortAndPrint("intersection of Ann and Bob", intersectionAnnBob);

        Set<Task> intersectionAllBob = getIntersected(unionSet, bobsTasks);
        sortAndPrint("intersection of All and Bob", intersectionAllBob);

        Set<Task> intersectionCarolBob = getIntersected(carolsTasks, bobsTasks);
        sortAndPrint("intersection of Carol and Bob", intersectionCarolBob);

        Set<Task> AllWithoutAnn = getDifference(unionSet, annsTasks);
        sortAndPrint("All tasks without Ann tasks", AllWithoutAnn);

        Set<Task> CarolWithoutAnn = getDifference(carolsTasks, annsTasks);
        sortAndPrint("Carol's tasks without Ann's tasks", CarolWithoutAnn);

        Set<Task> overlap = getUnion(List.of(
                getIntersected(annsTasks, bobsTasks),
                getIntersected(carolsTasks, bobsTasks),
                getIntersected(annsTasks, carolsTasks)
        ));
        sortAndPrint("Assigned to Multiples", overlap, sortByPriority);

        List<Set<Task>> sets = List.of(annsTasks, bobsTasks, carolsTasks);
        List<Task> overlapping = new ArrayList<>();
        for (Set<Task> set :
                sets) {
            Set<Task> dupes = getIntersected(set, overlap);
            overlapping.addAll(dupes);
        }
        Comparator<Task> priorityNatural = sortByPriority.thenComparing(Comparator.naturalOrder());
        sortAndPrint("Overlapping", overlapping, priorityNatural);

    }
private static void sortAndPrint(String header, Collection <Task> collection) {
        sortAndPrint(header, collection, null);
}
    private static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> sorter) {

        System.out.println("-".repeat(90));
        System.out.println(header);
        System.out.println("-".repeat(90));

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
     }

     public static Set<Task> getUnion(List<Set<Task>> sets) {
         Set<Task> unionSet = new HashSet<>();
         for (var tasksSet :
                 sets) {
             unionSet.addAll(tasksSet);
         }
         return unionSet;
     }
     public static Set<Task> getIntersected(Set<Task> setNumber, Set<Task> setNumber2) {
        Set<Task> set1 =  new HashSet<>(setNumber);
        Set<Task> set2 = new HashSet<>(setNumber2);
        set1.retainAll(set2);
        return set1;
     }
    public static Set<Task> getDifference(Set<Task> setNumber1, Set<Task> setNumber2) {
        Set<Task> set1 =  new HashSet<>(setNumber1);
        Set<Task> set2 = new HashSet<>(setNumber2);
        set1.removeAll(set2);
        return set1;
    }
}
