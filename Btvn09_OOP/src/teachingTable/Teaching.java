package teachingTable;

import Entity.Teacher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Teaching implements Serializable {
    private Teacher teacher;
    private List<TeachingTimeSheet> teachingTimeSheets = new ArrayList<>();
    private float allLesson;
    public Teaching() {
    }

    public Teaching(Teacher teacher, List<TeachingTimeSheet> teachingTimeSheets) {
        this.teacher = teacher;
        this.teachingTimeSheets = teachingTimeSheets;
    }

    public float getAllLesson() {
        return allLesson;
    }

    public void setAllLesson(float allLesson) {
        this.allLesson = allLesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<TeachingTimeSheet>teachingTimeSheets() {
        return teachingTimeSheets;
    }

    public void setTeachingSubjectClass(List<TeachingTimeSheet> teachingTimeSheets) {
        this.teachingTimeSheets = teachingTimeSheets;
    }

    @Override
    public String toString() {
        return "Teaching{" +
                "teacher=" + teacher +
                ", teachingSubjectClass=" + teachingTimeSheets +
                '}';
    }
}