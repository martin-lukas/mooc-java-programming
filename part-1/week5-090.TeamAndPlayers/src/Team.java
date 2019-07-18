import java.util.ArrayList;

public class Team {
    private String name;
    private int maxSize;
    private ArrayList<Player> players = new ArrayList<Player>();
    
    public Team(String name) {
        this.name = name;
        maxSize = 16;
    }
    
    public String getName() {
        return name;
    }
    
    public void addPlayer(Player player) {
        if (size() < maxSize) {
            players.add(player);
        }
    }
    
    public void printPlayers() {
        for (Player player : players) {
            System.out.println(player);
        }
    }
    
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public int goals() {
        int totalGoals = 0;
        for (Player player : players) {
            totalGoals += player.goals();
        }
        return totalGoals;
    }
    
    public int size() {
        return players.size();
    }
}
