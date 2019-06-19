package inheritancePractice;

public class FamilyMember {

    private int age;
    private String gender;


    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    private String hobby;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "age: " + age + ", gender: " + gender;
    }
//    public void displayAge(){
//        System.out.println(age);
//    }
//
//
//    public void isGender(){
//       String f= "female";
//       String m = "male";
//       if (gender = true){
//           System.out.println(f);
//       }
//       else {System.out.println(m);}
//
//
//    }

}
