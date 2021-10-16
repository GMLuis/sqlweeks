package entity;

import java.util.List;

public class Make {

	private int makeId;
	private String name;
	private List<Model> models;
	
	public Make(int makeId, String name,List<Model> models) {
		this.setMakeId(makeId);
		this.setName(name);
		this.setModels(models);
	}

	public int getMakeId() {
		return makeId;
	}

	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}
}
