package sabreacademy.scrum;

public class PBI {

	private String name;
	private String estimate = "";

	public PBI(String name) {
		this.name = name;
	}

	public PBI(String name, String estimate) {
		this(name);
		this.estimate = estimate;
	}

	public String getName() {
		return name;
	}

	public String getEstimate() {
		return estimate;
	}

}
