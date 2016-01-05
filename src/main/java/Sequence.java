public class Sequence {

    public Sequence(String username, String password, int country, int times) {
        this.username = username;
        this.country = country;
        this.password = password;
        this.times = times;
    }

    private String username;
    private int country;
    private String password;
    private int times;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
