package com.OnlineTutor.tutor.Tutor;

public class TutorInfoDto {

        private String name;
        private int studentCount;

        public TutorInfoDto(String name, int studentCount) {
            this.name = name;
            this.studentCount = studentCount;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    }


