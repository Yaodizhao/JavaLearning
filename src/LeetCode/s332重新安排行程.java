package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class s332重新安排行程 {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        String[] temp = new String[]{"JFK", "SFO"};
        tickets.add(List.of(temp));
        temp = new String[]{"JFK", "ATL"};
        tickets.add(List.of(temp));
        temp = new String[]{"SFO", "ATL"};
        tickets.add(List.of(temp));
        temp = new String[]{"ATL", "JFK"};
        tickets.add(List.of(temp));
        temp = new String[]{"ATL", "SFO"};
        tickets.add(List.of(temp));
        List<String> itinerary = new s332重新安排行程().findItinerary(tickets);
        System.out.println(itinerary);
    }

    public List<String> results = new ArrayList<>();
    public List<String> temp = new ArrayList<>();
    public int[] used;

    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort(Comparator.comparing(a -> a.get(1)));
        used = new int[tickets.size()];
        temp.add("JFK");
        findItineraryHelper(tickets);
        return results;
    }

    private boolean findItineraryHelper(List<List<String>> tickets) {
        if (temp.size() - 1 == tickets.size()) {
            results = new ArrayList<>(temp);
            return true;
        }
        for (int j = 0; j < tickets.size(); j++) {
            if (used[j] == 0 && tickets.get(j).get(0).equals(temp.get(temp.size() - 1))) {
                used[j] = 1;
                temp.add(tickets.get(j).get(1));
                if (findItineraryHelper(tickets)) {
                    return true;
                }
                temp.remove(temp.size() - 1);
                used[j] = 0;
            }
        }
        return false;
    }

}
