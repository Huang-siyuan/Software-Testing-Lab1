package ClassesForTask3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Siyuan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    private String name;
    private ArrayList<HyperintelligentBeing> members;

    public void deleteRandomMembers(int numOfMem){
        int size = members.size();
        if (size <= numOfMem) {
            throw new IllegalArgumentException("Can't delete too many members. At the least leave one guy for the game.");
        }

        while (numOfMem > 0){
            int x = members.size();
            // Get an index from [0, size - 1]
            int random = new Random().nextInt(x);
            members.remove(random);
            numOfMem--;
        }
    }

    public int calAbilityValue(){
        int abilityValue = 0;
        for (HyperintelligentBeing mem : members){
            abilityValue += mem.getIntelligence() + mem.getStamina();
        }
        return abilityValue;
    }

    public int getTeamSize(){
        if (members == null) {
            members = new ArrayList<>();
        }
        return members.size();
    }

    public void addMember(HyperintelligentBeing hb){
        if (members == null) {
            members = new ArrayList<>();
        }
        members.add(hb);
    }

    public void deleteMember(HyperintelligentBeing hb){
        members.remove(hb);
    }

    public void deleteMembers(int index){
        members.remove(index);
    }



}
