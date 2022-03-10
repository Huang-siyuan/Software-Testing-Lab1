import ClassesForTask3.Game;
import ClassesForTask3.HyperintelligentBeing;
import ClassesForTask3.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static ClassesForTask3.Gender.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DomainTest {

    HyperintelligentBeing hb1;
    HyperintelligentBeing hb2;
    HyperintelligentBeing hb3;
    HyperintelligentBeing hb4;
    HyperintelligentBeing hb5;

    HyperintelligentBeing hb6;
    HyperintelligentBeing hb7;
    HyperintelligentBeing hb8;
    HyperintelligentBeing hb9;
    HyperintelligentBeing hb10;

    Team team1;
    Team team2;

    Game game;

    @BeforeEach
    void init() throws Exception {
        hb1 = new HyperintelligentBeing("James", MALE, 70, 99, 202, 110);
        hb2 = new HyperintelligentBeing("Siyuan", MALE, 100, 100, 183, 90);
        hb3 = new HyperintelligentBeing("Olya", FEMALE, 100, 65, 170, 56);
        hb4 = new HyperintelligentBeing("Max", MALE, 99, 99, 193, 95);
        hb5 = new HyperintelligentBeing("Klimenkov", MALE, 70, 99, 202, 110);

        hb6 = new HyperintelligentBeing("Arina", FEMALE, 10, 10, 165, 50);
        hb7 = new HyperintelligentBeing("Siri", MALE, 20, 50, 15, 1);
        hb8 = new HyperintelligentBeing("Egor", MALE, 75, 65, 210, 130);
        hb9 = new HyperintelligentBeing("Abdalla", NON_BINARY, 20, 40, 202, 110);
        hb10 = new HyperintelligentBeing("Andrey", MALE, 10, 10, 178, 76);

        team1 = new Team();
        team1.setName("PBC CSKA Moscow");
        team1.addMember(hb1);
        team1.addMember(hb2);
        team1.addMember(hb3);
        team1.addMember(hb4);
        team1.addMember(hb5);

        team2 = new Team();
        team2.setName("Wakanda forever");
        team2.addMember(hb6);
        team2.addMember(hb7);
        team2.addMember(hb8);
        team2.addMember(hb9);
        team2.addMember(hb10);

        game= new Game();
        game.setTeam1(team1);
        game.setTeam2(team2);
    }

    @Nested
    class HBTest {

        @Test
        @DisplayName("Tests for illegal Argument of setter in HB class")
        void testForSetter() throws Exception {

            HyperintelligentBeing testObj = new HyperintelligentBeing();

            Exception e1 = assertThrows(IllegalArgumentException.class, () -> testObj.setName(null));
            assertEquals("Name shouldn't be null.", e1.getMessage());

            Exception e2 = assertThrows(IllegalArgumentException.class, () -> testObj.setGender(null));
            assertEquals("Gender shouldn't be null.", e2.getMessage());

            Exception e3 = assertThrows(IllegalArgumentException.class, () -> testObj.setHeight(-1));
            assertEquals("Height must be greater than zero!", e3.getMessage());

            Exception e4 = assertThrows(IllegalArgumentException.class, () -> testObj.setIntelligence(-1));
            assertEquals("Intelligence value must greater than 0.", e4.getMessage());

            Exception e5 = assertThrows(IllegalArgumentException.class, () -> testObj.setStamina(-1));
            assertEquals("Stamina value must greater than 0.", e5.getMessage());
        }

        @Test
        @DisplayName("Tests for illegal Argument of Constructor in HB class")
        void testConstructor() {
            Exception e1 = assertThrows(IllegalArgumentException.class, () -> new HyperintelligentBeing(null, MALE, 0, 0, 0, 0));
            assertEquals("Name or gender shouldn't be null.", e1.getMessage());

            Exception e2 = assertThrows(IllegalArgumentException.class, () -> new HyperintelligentBeing("Nobody", null, 0, 0, 0, 0));
            assertEquals("Name or gender shouldn't be null.", e2.getMessage());

            Exception e3 = assertThrows(IllegalArgumentException.class, () -> new HyperintelligentBeing("Nobody", MALE, -1, 0, 0, 0));
            assertEquals("Ability value must greater than 0.", e3.getMessage());

            Exception e4 = assertThrows(IllegalArgumentException.class, () -> new HyperintelligentBeing("Nobody", MALE, 0, -1, 0, 0));
            assertEquals("Ability value must greater than 0.", e4.getMessage());

            Exception e5 = assertThrows(IllegalArgumentException.class, () -> new HyperintelligentBeing("Nobody", MALE, 0, 0, -1, 0));
            assertEquals("Weight or height must be greater than zero!", e5.getMessage());

            Exception e6 = assertThrows(IllegalArgumentException.class, () -> new HyperintelligentBeing("Nobody", MALE, 0, 0, 0, -1));
            assertEquals("Weight or height must be greater than zero!", e6.getMessage());
        }
    }

    @Nested
    class TeamTest {

        @Test
        @DisplayName("Check deleteRandomMembers function")
        void checkDeleteRandomMembers(){
            Exception e = assertThrows(IllegalArgumentException.class, () -> team1.deleteRandomMembers(team1.getTeamSize()+1));
            assertEquals("Can't delete too many members. At the least leave one guy for the game.", e.getMessage());
        }

        @Test
        @DisplayName("Check add member to null arraylist.")
        void checkAddMemberToNullArrayList() throws Exception {
            Team testTeam = new Team();
            HyperintelligentBeing testHB = new HyperintelligentBeing("1", MALE, 1, 1, 1,1);
            ArrayList<HyperintelligentBeing> testArrayList = new ArrayList<>();
            testArrayList.add(testHB);
            testTeam.addMember(testHB);

            assertEquals(testArrayList, testTeam.getMembers());
        }
    }

    @Nested
    class GameTest{

        @Test
        @DisplayName("Check checkBalance function")
        void checkBalanceFunction(){
            team1.deleteRandomMembers(1);
            game.checkBalance();
            assertEquals(team1.getTeamSize(), team2.getTeamSize());
        }

        @Test
        @DisplayName("Test for empty group")
        void checkEmpty(){
            game.setTeam1(new Team("noName", new ArrayList<>()));
            Exception e = assertThrows(RuntimeException.class, ()->game.checkBalance());
            assertEquals("Team can't be empty!", e.getMessage());
        }

        @Test
        @DisplayName("Test for null team")
        void checkNull(){
            game.setTeam1(null);
            Exception e = assertThrows(RuntimeException.class, ()->game.checkBalance());
            assertEquals("Game must have 2 different teams.", e.getMessage());
        }

        @Test
        @DisplayName("Test for playing by itself")
        void checkPlay(){
            game.setTeam2(team1);
            Exception e = assertThrows(RuntimeException.class, ()->game.play());
            assertEquals("One team can't play with itself.", e.getMessage());
        }

        @Test
        @DisplayName("Check if there is only one group.")
        void checkIfOnlyOneGroup(){
            game.setTeam2(null);
            Exception e = assertThrows(RuntimeException.class, ()->game.play());
            assertEquals("There are no 2 teams.", e.getMessage());
        }
    }
}
