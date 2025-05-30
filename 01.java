class Student {
    private int studentId;
    private String name;
    private int daysAttended;

    // Constructor
    Student(int studentId, String name, int daysAttended) {
        this.studentId = studentId;
        this.name = name;
        this.daysAttended = daysAttended;
    }

    // Getters
    int getStudentId() {
        return studentId;
    }

    String getName() {
        return name;
    }

    int getDaysAttended() {
        return daysAttended;
    }

    // Setters
    void setDaysAttended(int daysAttended) {
        this.daysAttended = daysAttended;
    }
}

class Classroom {
    private Student[] students;
    private int count;

    public Classroom() {
        students = new Student[10]; // max 10 students
        count = 0;
    }

    void addStudent(Student s) {
        if (count < 10) {
            students[count++] = s;
        } else {
            System.out.println("Classroom is full.");
        }
    }

    void updateAttendance(int studentId, int newDays) {
        boolean found = false;
		for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i].setDaysAttended(newDays);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student ID " + studentId + " not found.");
        }
    }

    void displayAllStudents() {
        System.out.println("\nStudent Details:");
        for (int i = 0; i < count; i++) {
            Student s = students[i];
            System.out.println("ID: " + s.getStudentId() +
                               ", Name: " + s.getName() +
                               ", Days Attended: " + s.getDaysAttended());
        }
    }
}

class TestStudent {
    public static void main(String[] args) {
        Classroom classRoom = new Classroom();

        // Add 3 students
        classRoom.addStudent(new Student(101, "Alice Smith", 12));
        classRoom.addStudent(new Student(102, "Bob Jones", 15));
        classRoom.addStudent(new Student(103, "Carol Lee", 10));

        // Update Bob Jones attendance to 16
        classRoom.updateAttendance(102, 16);

        // Attempt to update a non-existent student (ID 104)
		classRoom.updateAttendance(104, 5);

        // Display all student details
        classRoom.displayAllStudents();
    }
}



