package demo.model;

public class Test {

	public static Integer TEST1 = 1;

	public static Integer TEST2 = 2;

	public static Integer TEST3 = 3;

	public static Integer TEST4 = 4;

	public static Integer TEST5 = 5;

	private Integer id;

	private String name;

	private String description;

	public Test() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && (obj.getClass().equals(this.getClass()))) {
			Test t = (Test) obj;
			// Assumes that if IDs are the same, then same object
			return (id == null ? t.id == null : id == t.id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}

}
