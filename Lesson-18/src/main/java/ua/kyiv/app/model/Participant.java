package ua.kyiv.app.model;

import ua.kyiv.app.model.enums.Level;

public class Participant {
	private Integer id;
	private String name;
	private String email;
	private Level level;
	private String primarySkill;
	
	public Participant() {
	}

	public Participant(Integer id, String name, String email, Level level, String primarySkill) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.level = level;
		this.primarySkill = primarySkill;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", name=" + name + ", email=" + email + ", level=" + level + ", primarySkill="
				+ primarySkill + "]";
	}
}
