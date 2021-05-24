package myProjectArray;

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
        Student[] studentInfo = new Student[10];
        for (int i = 0; i < studentInfo.length; i++) {
            Student student = new Student();
            studentInfo[i] = student;
            studentInfo[i].setStudentName("studentName"+i);
            studentInfo[i].setKoreanScore(70);
            studentInfo[i].setMathScore(50);
        }

        for (Student st : studentInfo) {
            System.out.println(st.getStudentName() + "의 국어점수 : " + st.getKoreanScore() +
                    "수학점수 : " + st.getMathScore());
            System.out.println("총점 : " + st.getTotalScore() + "평균 : " + st.getAverageScore());
        }

    }
}
