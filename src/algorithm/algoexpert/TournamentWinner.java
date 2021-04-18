package algorithm.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> teamResults = new HashMap<>();
        for (int i = 0; i < competitions.size(); i++) {
            var teams = competitions.get(i);
            var result = results.get(i);

            if (result == 1) {
                teamResults.merge(teams.get(0), 3, Integer::sum);
                teamResults.merge(teams.get(1), 0, Integer::sum);
            } else {
                teamResults.merge(teams.get(1), 3, Integer::sum);
                teamResults.merge(teams.get(0), 0, Integer::sum);
            }
        }

        return teamResults.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new IllegalArgumentException("Must not be empty"))
                .getKey();
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("HTML");
        strings.add("C#");
        competitions.add((strings));
        ArrayList<String> e = new ArrayList<>();
        e.add("C#");
        e.add("Python");
        competitions.add(e);
        ArrayList<String> e1 = new ArrayList<>();
        e1.add("Python");
        e1.add("HTML");
        competitions.add(e1);
        results.add(0);
        results.add(0);
        results.add(1);

        System.out.println(new TournamentWinner().tournamentWinner(competitions, results));
    }
}
