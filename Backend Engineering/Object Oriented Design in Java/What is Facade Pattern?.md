**DEFINITION: Provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.**

Facade Pattern can be used to hide all the complexity of one or more classes behind a clean, well-lit facade.

In simple terms, **the intent of Facade Pattern is to provide simplified interface to a subsystem.**

Based on the idea that when designing a system, it's better to keep the number of interactions between classes to a minimum (low coupling).

The Facade Pattern take a complex subsystem and make it easier to use by implementing a Facade class that provides one, more reasonable interface. However, it still leaves the subsystem accessible so it can be used directly. If you need the advanced functionality of the subsystem classes, they are available for your use.

Facades don't encapsulate the subsystem classes, they merely provide a simplified interface to their functionality. The subsystem classes still remain available for direct use by clients that need to use more specific interfaces.

## How to implement Facade Pattern?

The first step is to use composition so that the facade has access to all the components of the system.

The facade is passed a reference to each component of the subsystem in its constructor. The facade then assigns each to the corresponding instance variable.

## Real World Example

A stateless session bean (EJB component) can provide facade methods that hide the operations of multiple entity beans behind it.

## Advantages

- Allows us to avoid tight coupling between clients and subsystems.

---

The `AttendanceManagementSystem` component acts as a **unified interface** for all attendance system operations.

This approach <span style="color:green;font-weight:bold;background:beige;">hides the complexity of underlying components and exposes only high-level methods</span> like `createClass()`, `markAttendance()`, and `generateReport()`. Internally, these methods delegate tasks to the relevant modules (e.g., `ClassService`, `AttendanceService`, or `ReportService`) without revealing their internal workings.

**Spring Boot Implementation**

```
/**
 * Main facade class that provides a unified interface for all attendance system  * operations
 */
class AttendanceManagementSystem {
	private final ClassService classService;
	private final AttendanceService attendanceService;
	private final ReportService reportService;
	
	public AttendanceManagementSystem(ClassService classService, 
	                                  AttendanceService attendanceService,
	                                  ReportService reportService) {
		this.classService = classService;
		this.attendanceService = attendanceService;
		this.reportService = reportService;
	}

	// ========== CLASS MANAGEMENT OPERATIONS ==========

	/**
	 * Create a new class with given class name and teacher name
	 */
	public String createClass(String className, String teacherName) {
		return classService.createClass(className, studentName);
	}

	/**
	 * Get all classes in the system 
	 */
	public List<Class> getAllClasses() {
		return classService.getAllClasses();
	}

	/**
	 * Add a student to an existing class
	 */
	public boolean addStudentToClass(String classId, String studentName) {
		return classService.addStudentToClass(classId, studentName);
	}

	/**
	 * Get all student in a class
	 */
	 public List<Student> getAllStudentsInClass(String classId) {
		 return classService.getClass(classId).getStudents();
	 } 

	// ========= ATTENDANCE MANAGEMENT OPERATIONS ==========

	/*
	 * Mark attendance for multiple students in a class for a specific date
	 */
	public boolean markAttendance(String classId, LocalDate date, 
	                    Map<String, AttendanceStatus> studentAttendanceMap) {
		return attendanceService.markAttendance(classId, date,
		                                        studentAttendanceMap);
	}

	// ========== REPORT MANAGEMENT OPERATIONS ==========

	/*
	 * Generate comprehensive class attendance report for a specific month 
	 */
	public ClassAttendanceReport generateClassAttendanceReport(String classId
	                                            int year, int month) {
		return reportService.generateClassAttendanceReport(classId, year, month);
	}

}
```

The design decision to use this class as an interceptor for all incoming requests follows the <span style="color:green;font-weight:bold;background:beige;">Facade Pattern</span>.

Instead of allowing the user interface or external components to directly interact with multiple subsystems such as class creation, student registration, attendance tracking, or report generation, this class provides a **single point of access** to those functionalities.

---
