package myProjectArrayTest;

public class ScoreSystem {
    int engSubjectSum = 0;
    int mathSubjectSum = 0;
    int korSubjectSum = 0;
    float engSubjectAvg = 0;
    float mathSubjectAvg = 0;
    float korSubjectAvg = 0;
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
