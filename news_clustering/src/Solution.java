import java.lang.reflect.Array;
import java.util.*;

class Solution {

    public static void main(String[] args) {
//        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("AAAA12", "aa1+aa2"));
//        System.out.println(solution("handshake", "shake hands"));
    }

    // 집합 A,B가 공집합 -> J(A,B) = 1
    public static int solution(String str1, String str2) {
        double answer = 0;

        // 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        char[] ch1 = new char[str1.length()];   // 문자열을 char형으로 저장
        char[] ch2 = new char[str2.length()];
        ArrayList<String> list1 = new ArrayList<>();    // 두 문자씩 string형으로 저장
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();        // 합집합
        ArrayList<String> intersection = new ArrayList<>(); // 교집합

        for (int i = 0; i < ch1.length; i++) {
            ch1[i] = str1.charAt(i);

            System.out.print(ch1[i]);

            // 문자 두개씩 잘라서 삽입
            if (i == 0) continue;
            else {
                if (ch1[i - 1] >= 97 && ch1[i - 1] <= 122 && ch1[i] >= 97 && ch1[i] <= 122) {
                    StringBuilder sb = new StringBuilder("");
                    sb.append(ch1[i-1]).append(ch1[i]);
                    list1.add(sb.toString());
                    union.add(sb.toString());   // 합집합 배열에 삽입
                }
            }
        }

        System.out.println();

        for (int i = 0; i < ch2.length; i++) {
            ch2[i] = str2.charAt(i);

            System.out.print(ch2[i]);
            
            if (i == 0) continue;
            else {
                if (ch2[i - 1] >= 97 && ch2[i - 1] <= 122 && ch2[i] >= 97 && ch2[i] <= 122) {
                    StringBuilder sb = new StringBuilder("");
                    sb.append(ch2[i-1]).append(ch2[i]);
                    list2.add(sb.toString());
                    union.add(sb.toString());
                }
            }
        }

        System.out.println();

        // 교집합 확인하고 넣어주고, 합집합에 교집합이 두번 포함됐으므로 한 번 삭제
        if (list1.size() < list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (list2.contains(list1.get(i))) {
                    intersection.add(list1.get(i));
                    union.remove(list1.get(i));
                }
            }
        } else {
            for (int i = 0; i < list2.size(); i++) {
                if (list1.contains(list2.get(i))) {
                    intersection.add(list2.get(i));
                    union.remove(list2.get(i));
                }
            }
        }



        for (int i = 0; i < intersection.size(); i++) {
            System.out.print(intersection.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < union.size(); i++) {
            System.out.print(union.get(i) + " ");
        }
        System.out.println();

        System.out.println(intersection.size());
        System.out.println(union.size());

        if (union.size() == 0)
            return 65536;

        answer = (intersection.size() / (double)union.size()) * 65536;
        return (int)answer;
    }
}

