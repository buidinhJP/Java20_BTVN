package teachingTable;

import Entity.Subject;

import java.io.Serializable;

public class TeachingTimeSheet implements Serializable {
    private Subject subject;
    private int totalClass;
    private int totallesson;

    public TeachingTimeSheet() {
    }

    public TeachingTimeSheet(Subject subject, int totalClassList) {
        this.subject = subject;
        this.totalClass = totalClassList;
    }

    public int getTotallesson() {
        return totallesson;
    }

    public void setTotallesson(int totallesson) {
        this.totallesson = totallesson;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getTotalClass() {
        return totalClass;
    }

    public void setTotalClass(int totalClass) {
        this.totalClass = totalClass;
    }

    @Override
    public String toString() {
        return "Table{" +
                "subject=" + subject +
                ", totalClassList=" + totalClass +
                '}';
    }
}