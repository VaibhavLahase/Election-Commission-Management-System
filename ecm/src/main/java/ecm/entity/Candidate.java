package ecm.entity;

public class Candidate {
    private int c_id;
    private String cname;
    private String partyname;
    private String state;
    private String assembely;
    private String gender;
    private int age;
    
    public Candidate(){
    
    }
    
    public Candidate(int c_id, String cname, String partyname, String state, String assembely, String gender, int age) {
        this.c_id = c_id;
        this.cname = cname;
        this.partyname = partyname;
        this.state = state;
        this.assembely = assembely;
        this.gender = gender;
        this.age = age;
    }
    public int getC_id() {
        return c_id;
    }
    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getPartyname() {
        return partyname;
    }
    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getAssembely() {
        return assembely;
    }
    public void setAssembely(String assembely) {
        this.assembely = assembely;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Candidate [c_id=" + c_id + ", cname=" + cname + ", partyname=" + partyname + ", state=" + state
                + ", assembely=" + assembely + ", gender=" + gender + ", age=" + age + "]";
    }
}
