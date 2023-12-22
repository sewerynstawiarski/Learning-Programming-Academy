
interface Player{

    String name();
}

record BaseballPlayer(String name, String position) implements Player {}
record FootbalPlayer(String name, String position) implements Player {}

record VolleyballPlayer(String name, String position) implements Player{}

public class Main {
    public static void main(String[] args) {

        var philly = new Affiliation("city", "Philadelphia, PA", "USA");

    BaseballTeam phillies1 =  new BaseballTeam("Philadelphia");
    BaseballTeam astros1 =  new BaseballTeam("Houston Astros");

    scoreResult(phillies1, 3, astros1, 5);

    SportTeam phillies2 =  new SportTeam("Philadelphia");
    SportTeam astros2 =  new SportTeam("Houston Astros");

    scoreResult(phillies2, 3, astros2, 5);

    Team<BaseballPlayer, Affiliation> phillies3 =  new Team<>("Philadelphia", philly);
    Team<BaseballPlayer, Affiliation> astros3 =  new Team<>("Houston Astros", philly);

    scoreResult(phillies3, 3, astros3, 5);

    var harper = new BaseballPlayer("B Harper", "Right Fielder");
    var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
    var guthrie =  new BaseballPlayer("D Guthrie", "Center Fielder");
    phillies3.addTeamMember(guthrie);
    phillies3.addTeamMember(harper);
    phillies3.addTeamMember(marsh);
    phillies3.listTeamMembers();

    SportTeam afc1 = new SportTeam("Adelaide Crows");
    Team<FootbalPlayer, String> afc = new Team<>("Adelaide Crows", "City of Adelaide, South Australia, Australia");
    var tex = new FootbalPlayer("Tex Walker", "Centre half forward");
    afc.addTeamMember(tex);
    var rory = new FootbalPlayer("Rory Laird", "Midfield");
    afc.addTeamMember(rory);
    afc.listTeamMembers();

    Team<VolleyballPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
    adelaide.addTeamMember(new VolleyballPlayer("N Roberts", "Setter"));
    adelaide.listTeamMembers();

    var canberra = new Team<VolleyballPlayer, Affiliation>("Camberra Heat");
    canberra.addTeamMember(new VolleyballPlayer("B Blue", "opposite"));
    canberra.listTeamMembers();
    scoreResult(canberra, 0, adelaide, 1);

//    Team<Integer> melbourneVB = new Team<>("Melbourne Vipers");

    }

    public static void scoreResult (BaseballTeam team1, int t1_score, BaseballTeam team2, int t2_score) {
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score, t1_score);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }
    public static void scoreResult (SportTeam team1, int t1_score, SportTeam team2, int t2_score) {
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score, t1_score);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }
    public static void scoreResult (Team team1, int t1_score, Team team2, int t2_score) {
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score, t1_score);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
