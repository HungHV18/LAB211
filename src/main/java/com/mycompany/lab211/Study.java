class Student implements mainInterface, Comparable<Student> {
	private String ID;
	private String studentName;
	private String semester;
	private String courseName;

	public Student() {
		create_ID();
		create_Student_Name();
		create_Semester();
		create_Course_Name();
	}

	public void create_ID() {
		System.out.print("ID Student: ");
		set_ID(sc.nextLine());
	}

	public void create_Student_Name() {
		System.out.print("Name of student: ");
		set_Student_Name(sc.nextLine());
	}

	public void create_Semester() {
		System.out.print("Semester: ");
		set_Semester(sc.nextLine());
	}

	public void create_Course_Name() {
		System.out.print("Course name: ");
		set_Course_Name(sc.nextLine());
	}

	public void set_ID(String ID) {
		this.ID = ID;
	}

	public void set_Student_Name(String studentName) {
		this.studentName = studentName;
	}

	public void set_Semester(String semester) {
		this.semester = semester;
	}

	public void set_Course_Name(String courseName) {
		switch (courseName) {
			case "Java":
			case "java":
				this.courseName = "Java";
				break;
			case ".Net":
			case ".net":
				this.courseName = ".Net";
				break;
			case "C":
			case "c":
				this.courseName = "C";
				break;
			case "C++":
			case "c++":
				this.courseName = "C++";
				break;
			default: {
				System.out.println("There are only three courses: Java, .Net, C, C++");
				create_Course_Name();
			}
		}
	}

	public String get_ID() {
		return this.ID;
	}

	public String get_Student_Name() {
		return this.studentName;
	}

	public String get_Semester() {
		return this.semester;
	}

	public String get_Course_Name() {
		return this.courseName;
	}

	public int compareTo(Student student){
		return this.studentName.compareTo(student.get_Student_Name());
	}

	public void printStudent(){
		System.out.println(get_ID() +" "+ get_Student_Name() + " " + get_Semester() + " " + get_Course_Name());
	}

}