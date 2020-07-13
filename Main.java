import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        String stringCnt = br.readLine();
        int cnt = Integer.parseInt(stringCnt);
        for(int i=0;i<cnt;i++) {
            String temp = br.readLine();
            // String[] wordArray = temp.split(" ");
            StringTokenizer st = new StringTokenizer(temp); // temp 문자열을 공백을 기준으로 토큰으로 나누어 순서대로 호출할 수 있게 해줌
            while (st.hasMoreTokens()) { // 문장의 모든 단어 iterate
                String word = st.nextToken(); // 단어 하나 불러오기
                for (int j=0;j<word.length();j++) {
                    stack.push(word.substring(j, j+1)); // 단어 알파벳으로 슬라이싱하고 push
                }
                while (!stack.empty()) {
                    bw.write(stack.pop()); // stack에 넣어진 단어 1개에 대한 모든 알파벳 pop
                }
                bw.write(" "); // 단어 간 띄어쓰기
            }
            bw.write("\n"); // 다음 문장으로 가기 위한 개행
            bw.flush(); // 작성된(남아있는) 버퍼 콘솔에 출력하기
        }
        bw.close(); // 버퍼 닫기
    }
}
