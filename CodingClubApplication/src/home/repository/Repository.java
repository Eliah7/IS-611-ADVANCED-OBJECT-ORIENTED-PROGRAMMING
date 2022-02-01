package home.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;

import java.util.List;
import java.util.Map;

public abstract class Repository<T> {
    public String COLLECTION_NAME;
    public DatabaseConnector databaseConnector;

    Repository(){
        this.databaseConnector = DatabaseFactory.createSingletonDatabaseConnector();
    }

    public List<T> getAll() throws Exception{
        return null;
    }

    public boolean add(T element) throws Exception{
        DocumentReference docRef = this.databaseConnector.db.collection(COLLECTION_NAME).document();
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> data = objectMapper.convertValue(element, Map.class);
        System.out.println("Data to send" +  data.toString());
        ApiFuture<com.google.cloud.firestore.WriteResult> result = docRef.set(data);
        result.get();
        return result.isDone();
    }

    public void delete(){

    }

    public void size(){

    }

}
