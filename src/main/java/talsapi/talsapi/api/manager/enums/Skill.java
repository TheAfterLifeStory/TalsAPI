package talsapi.talsapi.api.manager.enums;

public enum Skill {

    Skill1("Skill1","SkillLevel1"),
    Skill2("Skill2","SkillLevel2"),
    Skill3("Skill3","SkillLevel3"),
    Skill4("Skill4","SkillLevel4"),
    Skill5("Skill5","SkillLevel5"),
    Skill6("Skill6","SkillLevel6"),
    Skill7("Skill7","SkillLevel7"),
    Skill8("Skill8","SkillLevel8"),
    Skill9("Skill9","SkillLevel9"),
    Skill10("Skill10","SkillLevel10");

    private String skill,skillLevel;

    Skill(String skill, String skillLevel) {
        this.skill = skill;
        this.skillLevel = skillLevel;
    }

    public String getSkillMySQL()
    {
        return skill;
    }

    public String getSkillLevelMySQL()
    {
        return skillLevel;
    }
}
