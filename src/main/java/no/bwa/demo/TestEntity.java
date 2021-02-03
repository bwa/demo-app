package no.bwa.demo;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TestEntity")

public class TestEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", length=36)
    private String id;   
    
    @Column(name = "navn", length=200)
    private String navn;   

    
    public TestEntity() {
    	this.id = UUID.randomUUID().toString();
    }

    @Override
	public String toString() {
		return "TestEntity [id=" + id + ", navn=" + navn + "]";
	}

	public TestEntity(String id, String navn) {
        this.id = id;
        this.navn = navn;
    }
    
}