package no.bwa.demo;

import java.util.List;

public interface PersistenceService {

    public List<TestEntity> getEntities();
    public boolean addEntity(TestEntity entity);
    
}