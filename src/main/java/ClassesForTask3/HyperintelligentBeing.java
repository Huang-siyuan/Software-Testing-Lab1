package ClassesForTask3;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class HyperintelligentBeing {
    public final String description = "A high-IQ cosmic creature with the same appearance as a human being. Love to play super cricket.";

    private String name;
    private Gender gender;
    private Integer intelligence;
    private Integer stamina;
    private Integer height; // cm
    private Integer weight; // kg

    public HyperintelligentBeing(String name, Gender gender, Integer intelligence,
                                 Integer stamina, Integer height, Integer weight) throws Exception {

        if (name == null || gender == null) {
            throw new IllegalArgumentException("Name or gender shouldn't be null.");
        }
        if (intelligence < 0 || stamina < 0) {
            throw new IllegalArgumentException("Ability value must greater than 0.");
        }
        if (weight < 0 || height < 0) {
            throw new IllegalArgumentException("Weight or height must be greater than zero!");
        }
        this.name = name;
        this.gender = gender;
        this.intelligence = intelligence;
        this.stamina = stamina;
        this.height = height;
        this.weight = weight;
    }

    public void setWeight(Integer weight) throws Exception {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight must be greater than zero!");
        }
        this.weight = weight;
    }

    public void setHeight(Integer height) throws Exception {
        if (height < 0) {
            throw new IllegalArgumentException("Height must be greater than zero!");
        }
        this.height = height;
    }

    public void setName(String name) throws Exception {
        if (name == null) {
            throw new IllegalArgumentException("Name shouldn't be null.");
        }
        this.name = name;
    }

    public void setGender(Gender gender) throws Exception {
        if (gender == null) {
            throw new IllegalArgumentException("Gender shouldn't be null.");
        }
        this.gender = gender;
    }

    public void setIntelligence(Integer intelligence) throws Exception {
        if (intelligence < 0) {
            throw new IllegalArgumentException("Intelligence value must greater than 0.");
        }
        this.intelligence = intelligence;
    }

    public void setStamina(Integer stamina) throws Exception {
        if (stamina < 0) {
            throw new IllegalArgumentException("Stamina value must greater than 0.");
        }
        this.stamina = stamina;
    }
}
