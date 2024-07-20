package medilinker;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;


public class Sickness {
    private String sicknessName;
    private String description;
    private String recommendedFoods;
    private String notRecommendedFoods;
    private String exercises;

    public Sickness() {
    }
//Constructor
    public Sickness(String sicknessName, String description, String recommendedFoods, String notRecommendedFoods, String exercises) {
        this.sicknessName = sicknessName;
        this.description = description;
        this.recommendedFoods = recommendedFoods;
        this.notRecommendedFoods = notRecommendedFoods;
        this.exercises = exercises;
    }
//Setter and Getter methods
    public String getSicknessName() {
        return sicknessName;
    }

    public void setSicknessName(String sicknessName) {
        this.sicknessName = sicknessName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecommendedFoods() {
        return recommendedFoods;
    }

    public void setRecommendedFoods(String recommendedFoods) {
        this.recommendedFoods = recommendedFoods;
    }

    public String getNotRecommendedFoods() {
        return notRecommendedFoods;
    }

    public void setNotRecommendedFoods(String notRecommendedFoods) {
        this.notRecommendedFoods = notRecommendedFoods;
    }

    public String getExercises() {
        return exercises;
    }

    public void setExercises(String exercises) {
        this.exercises = exercises;
    }


}
//Class represents a sickness and defines the properties of sickness, such as sickness name , description , recommeneded foods and not recommended foods
//provides getter and setter methods for each of these properties as well as a constructor method to create new sickness objects