package entity;

public class Model {
	private int modelId;
	private String name;
	private String color;
	private String year;
	private String trim;

	
	public Model(int modelId, String name, String color, String year, String trim) {
		this.setModelId(modelId);
		this.setName(name);
		this.setColor(color);
		this.setYear(year);
		this.setTrim(trim);
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
