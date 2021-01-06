package cv;

import java.util.ArrayList;
import java.util.Map;

public class Cv {

    /**
     * Egy önéletrajzot reprezentáló osztályt kell létrehozni, melyben van egy név,
     * valamint skillek (hogy mihez ért az illető). A skill egy névvel és egy számmal (szint) rendelkezik,
     * utóbbi 1 - 5 között.
     * <p>
     * Az önéletrajz a Cv osztály pár metódussal, a skill a Skill osztály.
     * <p>
     * A skillek megadása a nevével, valamint a szintjével történik, pl. programming (5).
     * <p>
     * A findSkillLevelByName() a skill neve alapján visszaadja annak szintjét.
     */

    private final String name;
    ArrayList<Skill> skills = new ArrayList<>();


    public Cv(String name) {
        this.name = name;
    }

    public void addSkills(String... addSkills) {

        for (String s : addSkills) {
            String skill = (s.split("\\("))[0].trim();
            String clean = s.replaceAll("\\D+", "");
            int level = Integer.parseInt(clean);

            Skill newSkill = new Skill(skill, level);
            skills.add(newSkill);
        }
    }

    public String getName() {
        return name;
    }


    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public int findSkillLevelByName(String skill) throws SkillNotFoundException {

        int result = 0;
        for (Skill s : skills) {

            if (skill.equals(s.getName())) {
                result = s.getLevel();
            }
        }
        if (result == 0) {
            throw new SkillNotFoundException();
        }

        return result;
    }

    public static void main(String[] args) throws SkillNotFoundException {
        Cv cv1 = new Cv("John Doe");
        System.out.println("Assert: 0 , Result:" + cv1.getSkills().size());
        cv1.addSkills("programming (5)", "oo design (2)");
        System.out.println("Assert: 2, Result: " + cv1.getSkills().size());
        System.out.println("Assert: programming, Result:" + cv1.getSkills().get(0).getName());
        System.out.println("Assert: 5, Result: " + cv1.getSkills().get(0).getLevel());

        Cv cv2 = new Cv("John Doe");
        System.out.println(SkillNotFoundException.class + " " + cv2.findSkillLevelByName("programming"));

    }


}
