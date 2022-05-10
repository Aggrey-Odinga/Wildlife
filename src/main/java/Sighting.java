import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sighting {
    private int id;
    private int animalId;
    private String ranger;
    private String location;

    private final Sql2o sql2o;

    public Sighting(int id, int animalId, String ranger) {
        this.id = id;
        this.animalId = animalId;
        this.ranger = ranger;
        this.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", null,  null);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getRanger() {
        return ranger;
    }

    public void setRanger(String ranger) {
        this.ranger = ranger;
    }

    public void save() {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO sightings (animalId, ranger, location) VALUES (:animalid, :ranger, :location)";
            con.createQuery(sql)
                    .addParameter("animalId", this.animalId)
                    .addParameter("ranger", this.ranger)
                    .addParameter("location", this.location)
                    .executeUpdate();
        }
    }

    public List<Sighting> getSightings(int animalId) {
        String select = "Select animalId, ranger, location from sightings where animalId = :animalId";
        try(Connection con = sql2o.open()) {
            return con.createQuery(select)
                    .addParameter("animalId", animalId)
                    .executeAndFetch(Sighting.class);
        }
    }
}
