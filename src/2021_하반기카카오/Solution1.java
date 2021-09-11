import java.util.*;


class Solution1 {
    static public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> accuseMap = new HashMap<>();
        Map<String, Integer> nameMap = new HashMap<>();
        List<String>[] list = new ArrayList[id_list.length];
        List<String> accuseMan = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
            list[i] = new ArrayList<>();
        }

        int nameCnt = 0;
        for (String id : id_list) {
            nameMap.put(id, nameCnt++);
            accuseMap.put(id, 0);
        }
        for (String repo : report) {
            String[] person = repo.split(" ");
            int idNum = nameMap.get(person[0]);
            if (!list[idNum].contains(person[1])) {
                accuseMap.put(person[1], accuseMap.get(person[1]) + 1);
                list[idNum].add(person[1]);
            }
        }

        for (String accuse : accuseMap.keySet()) {
            if (accuseMap.get(accuse) >= k) {
                accuseMan.add(accuse);
            }
        }
        for (String man : accuseMan) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].contains(man)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] answer = solution(id_list, report, k);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }
}