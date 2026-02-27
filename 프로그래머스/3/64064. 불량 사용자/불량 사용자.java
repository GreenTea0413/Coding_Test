import java.util.*;

class Solution {

    Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        boolean[] visited = new boolean[user_id.length];
        dfs(user_id, banned_id, 0, visited, new HashSet<>());
        return result.size();
    }

    void dfs(String[] user_id, String[] banned_id, int depth, boolean[] visited, Set<String> current) {
        if (depth == banned_id.length) {
            result.add(new HashSet<>(current));
            return;
        }

        for (int i = 0; i < user_id.length; i++) {

            if (visited[i]) continue;

            if (match(user_id[i], banned_id[depth])) {

                visited[i] = true;
                current.add(user_id[i]);

                dfs(user_id, banned_id, depth + 1, visited, current);

                visited[i] = false;
                current.remove(user_id[i]);
            }
        }
    }

    boolean match(String user, String banned) {

        if (user.length() != banned.length()) return false;

        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }
        return true;
    }
}