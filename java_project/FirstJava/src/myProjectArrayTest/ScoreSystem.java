package myProjectArrayTest;

public class ScoreSystem {
    private int engSubjectSum = 0;
    private int mathSubjectSum = 0;
    private int korSubjectSum = 0;
    private float engSubjectAvg = 0;
    private float mathSubjectAvg = 0;
    private float korSubjectAvg = 0;

    public int getEngSubjectSum() {
        return engSubjectSum;
    }

    public void setEngSubjectSum(int engSubjectSum) {
        this.engSubjectSum = engSubjectSum;
    }

    public int getMathSubjectSum() {
        return mathSubjectSum;
    }

    public void setMathSubjectSum(int mathSubjectSum) {
        this.mathSubjectSum = mathSubjectSum;
    }

    public int getKorSubjectSum() {
        return korSubjectSum;
    }

    public void setKorSubjectSum(int korSubjectSum) {
        this.korSubjectSum = korSubjectSum;
    }

    public float getEngSubjectAvg() {
        return engSubjectAvg;
    }

    public void setEngSubjectAvg(float engSubjectAvg) {
        this.engSubjectAvg = engSubjectAvg;
    }

    public float getMathSubjectAvg() {
        return mathSubjectAvg;
    }

    public void setMathSubjectAvg(float mathSubjectAvg) {
        this.mathSubjectAvg = mathSubjectAvg;
    }

    public float getKorSubjectAvg() {
        return korSubjectAvg;
    }

    public void setKorSubjectAvg(float korSubjectAvg) {
        this.korSubjectAvg = korSubjectAvg;
    }

    void getSubjectSumAvg(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            engSubjectSum += students[i].getEng();
            mathSubjectSum += students[i].getMath();
            korSubjectSum += students[i].getKor();
        }
        engSubjectAvg = (float)engSubjectSum /  students.length;
        mathSubjectAvg = (float)mathSubjectSum / students.length;
        korSubjectAvg = (float)korSubjectSum / students.length;
    }
}
