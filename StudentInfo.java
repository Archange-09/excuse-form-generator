public class StudentInfo {
    private String name, course, yearSection, studentId, startDate, endDate, reason, nature;

    public StudentInfo(String name, String course, String yearSection, String studentId,
                       String startDate, String endDate, String reason, String nature) {
        this.name = name;
        this.course = course;
        this.yearSection = yearSection;
        this.studentId = studentId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.nature = nature;
    }

    // Getters
    public String getName() { return name; }
    public String getCourse() { return course; }
    public String getYearSection() { return yearSection; }
    public String getStudentId() { return studentId; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public String getReason() { return reason; }
    public String getNature() { return nature; }
}