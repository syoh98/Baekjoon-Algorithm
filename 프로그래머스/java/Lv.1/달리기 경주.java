import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }

        for(String player : callings) {
            int playerNum = map.get(player); // 추월자

            String frontPlayer = players[playerNum-1];

            map.put(frontPlayer, playerNum);
            players[playerNum] = frontPlayer;

            map.put(player, playerNum-1);
            players[playerNum-1] = player;
        }

        return players;
    }
}
