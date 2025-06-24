import java.io.*;
import java.util.*;

public class Main {

    static class Student {
        int id;       // 학생 번호
        int count;    // 추천 수
        int time;     // 사진이 게시된 시간

        Student(int id, int time) {
            this.id = id;
            this.count = 1;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 사진틀 갯수
        int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        // 전체 학생의 총 추천 횟수
        int count = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int[] arr = new int[count];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Student> frames = new ArrayList<>();
        for (int time = 0; time < count; time++) {
            int id = arr[time];
            boolean isAlreadyInFrame = false;

            // 이미 사진틀에 있는지 확인
            for (Student student : frames) {
                if (student.id == id) {
                    student.count++;
                    isAlreadyInFrame = true;
                    break;
                }
            }

            if (isAlreadyInFrame) continue;

            // 사진틀에 없을 경우
            if (frames.size() < N) {
                frames.add(new Student(id, time));
            } else {
                // 가장 추천 수가 적고, 오래된 학생 제거
                frames.sort((a, b) -> {
                    if (a.count == b.count) return a.time - b.time;
                    return a.count - b.count;
                });
                frames.remove(0);
                frames.add(new Student(id, time));
            }
        }

        // 최종적으로 남은 학생 번호 오름차순 출력
        frames.sort(Comparator.comparingInt(a -> a.id));
        for (Student student : frames) {
            System.out.print(student.id + " ");
        }
    }
}
