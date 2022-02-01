package home.repository;

public class DatabaseFactory {
    private static DatabaseConnector databaseConnector;

    public static DatabaseConnector createSingletonDatabaseConnector(){
        if(databaseConnector == null){
            databaseConnector = new DatabaseConnector();
        }
        return databaseConnector;
    }
}
