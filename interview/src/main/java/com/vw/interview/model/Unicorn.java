package com.vw.interview.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "unicorn")
public class Unicorn implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long unicornId;
	private String name;
	private String hairColor;
	private int hornLength;
	private String hornColor;
	private String eyeColor;
	private int height;
	private String heightUnit;
	private int weight;
	private String weightUnit;
	
	@OneToMany(mappedBy = "unicorn",
            cascade = CascadeType.ALL, 
            orphanRemoval = true)
	private List<IdentifiableMarks> identifiableMarks = new ArrayList<>();

	public Unicorn() {
	}

	public Unicorn(String name, String hairColor, int hornLength, String hornColor, String eyeColor, int height,
			String heightUnit, int weight, String weightUnit, List<IdentifiableMarks> identifiableMarks) {
		this.name = name;
		this.hairColor = hairColor;
		this.hornLength = hornLength;
		this.hornColor = hornColor;
		this.eyeColor = eyeColor;
		this.height = height;
		this.heightUnit = heightUnit;
		this.weight = weight;
		this.weightUnit = weightUnit;
		this.identifiableMarks = identifiableMarks;
	}

	public void setIdentifiableMarks(List<IdentifiableMarks> identifiableMarks) {
		this.identifiableMarks = identifiableMarks;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getUnicornId() {
        return unicornId;
    }
    public void setUnicornId(long unicornId) {
        this.unicornId = unicornId;
    }
    
    @Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "hair_color")
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	
	@Column(name = "horn_length")
	public int getHornLength() {
		return hornLength;
	}
	public void setHornLength(int hornLength) {
		this.hornLength = hornLength;
	}
	
	@Column(name = "horn_color")
	public String getHornColor() {
		return hornColor;
	}
	public void setHornColor(String hornColor) {
		this.hornColor = hornColor;
	}
	
	@Column(name = "eye_color")
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	
	@Column(name = "height")
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Column(name = "height_unit")
	public String getHeightUnit() {
		return heightUnit;
	}
	public void setHeightUnit(String heightUnit) {
		this.heightUnit = heightUnit;
	}
	
	@Column(name = "weight")
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Column(name = "weight_unit")
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
    
    
}
