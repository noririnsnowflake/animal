package com.example.demo.entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class IndexEntity {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int unique_key;
	private String name;
	private String features;
	private String habitat;
	private Blob image;

	public int getUniqueKey() {
        return unique_key;
    }
    public void setUniqueKey(int unique_key) {
        this.unique_key = unique_key;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public String getHabitat() {
		return habitat;
	}
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
    public Blob getImage() {
        return image;
    }
    public void setImage(Blob image) {
        this.image = image;
    }
}

