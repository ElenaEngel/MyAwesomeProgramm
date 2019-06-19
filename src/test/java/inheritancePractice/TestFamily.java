package inheritancePractice;

import inheritancePractice.Daughter;
import inheritancePractice.Father;
import inheritancePractice.Mother;
import inheritancePractice.Son;
import org.testng.annotations.Test;

public class TestFamily {
    @Test

    public void testFamily(){
Mother mother = new Mother();
mother.setAge(40);
mother.setGender("female");
Father father = new Father();
father.setAge(45);
father.setGender("male");
Son  son = new Son();
son.setAge(10);
son.setGender("male");
Daughter daughter = new Daughter();
daughter.setAge(17);
daughter.setGender("female");

//inheritancePractice.FamilyMember[] members = new inheritancePractice.FamilyMember[] {mother, father, daughter, son};

//for (inheritancePractice.FamilyMember f: members)
//{System.out.println(f.info());}

      System.out.println("inheritancePractice.Mother: "+ mother);


        mother.motherInfo();
        mother.motherHobby();

        System.out.println("inheritancePractice.Father: "+ father);
        father.fatherInfo();
        father.fatherHobby();

        System.out.println("inheritancePractice.Daughter: "+ daughter);


        daughter.daughterInfo();
        daughter.daughterHobby();

        System.out.println("inheritancePractice.Son: "+ son);
        son.sonInfo();
       son.sonHobby();


    }
}
