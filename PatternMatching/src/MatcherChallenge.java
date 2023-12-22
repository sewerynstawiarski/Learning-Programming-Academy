import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherChallenge {
    public static void main(String[] args) {
        String emails = """
                john.boy@valid.com
                john.boy@invalid
                jane.doe-smith@valid.co.uk
                jane_Doe1976@valid.co.uk
                bob-1964@valid.net
                bob!@invalid.com
                elaine@valid-test.com.au
                elaineinvalid1983@.com
                david@valid.io
                david@invalid..com
                """;

        Pattern emailPattern = Pattern.compile("([\\w._/-]+)@([\\w-]+)[.]([\\w]+[\\w.]*)");
        Matcher emailsMatcher = emailPattern.matcher(emails);


        emailsMatcher.results().forEach(s -> System.out.println("Username: " + s.group(1) + "\n Domain: " + s.group(2) +"." + s.group(3)));



    }
}
