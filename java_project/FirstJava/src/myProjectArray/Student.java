package myProjectArray;

import java.util.Scanner;

public class Student {
    private String studentName;
    private int koreanScore;
    private int mathScore;
    private int totalScore;
    private double averageScore;

    public int getTotalScore() {
        return totalScore = koreanScore + mathScore;
    }

    public double getAverageScore() {
        return averageScore = totalScore / 2;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getKoreanScore() {
        return koreanScore;
    }

    public void setKoreanScore(int koreanScore) {
        this.koreanScore = koreanScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }



    public static void main(String[] args) {
        Student[] studentInfo = new Student[3];
        for (int i = 0; i < studentInfo.length; i++) {
            Student student = new Student();
            studentInfo[i] = student;
            System.out.print("이름을 입력하여 주세요 : ");
            String studentName = getInputString();
            studentInfo[i].setStudentName(studentName);
            System.out.print("국어 점수를 입력하여 주세요 : ");
            int koreanScore = getInputInteger();
            studentInfo[i].setKoreanScore(koreanScore);
            System.out.print("수학점수를 입력하여 주세요 : ");
            int mathScore = getInputInteger();
            studentInfo[i].setMathScore(mathScore);
        }

        for (Student st : studentInfo) {
            System.out.println(st.getStudentName() + "의 국어점수 : " + st.getKoreanScore() +
                    "수학점수 : " + st.getMathScore());
            System.out.println("총점 : " + st.getTotalScore() + "평균 : " + st.getAverageScore());
        }

    }

    private static int getInputInteger() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return  Integer.parseInt(input);
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
