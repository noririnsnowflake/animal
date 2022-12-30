package com.example.demo.model;

public class RegistForm {

	private String id;
	private String animal;
    private String features;
    private String habitat;
    private String picture1;

    public RegistForm(String id,String animal,String features,String habitat,String picture1) {
    	this.animal = animal;
        this.features = features;
        this.habitat = habitat;
        this.picture1 = picture1;
    }

    public RegistForm() {
        this("","","","","");
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getHabitat() {
        return habitat;
    }
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getAnimal() {
        return animal;
    }
    public void setAnimal(String animal) {
        this.animal = animal;
    }

	public String getFeatures() {
        return features;
    }
    public void setFeatures(String features) {
        this.features = features;
    }
    public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
}
