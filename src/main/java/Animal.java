import org.sql2o.*;

public class Animal {
    private int id;
    private String name;
    private String health;
    private int age;
    private boolean endangered;
    private final Sql2o sql2o;

    public Animal(int id, String name, String health, int age, boolean endangered) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.age = age;
        this.endangered = endangered;
        this.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "moringa",  "access");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return health;
    }

    public int getAge() {
        return age;
    }

    public boolean isEndangered() {
        return endangered;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEndangered(boolean endangered) {
        this.endangered = endangered;
    }

    public void save() {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO animals (name, health, age, endangered) VALUES (:name, :health, :age,:endangered)";
            con.createQuery(sql)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .addParameter("endangered", this.endangered)
                    .executeUpdate();
        }
    }

    public Animal get(int id) {
        String select = "Select id, name, health, age, endangered from animals where id = :id";
        try(Connection con = sql2o.open()) {
            return con.createQuery(select)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
        }
    }


}
