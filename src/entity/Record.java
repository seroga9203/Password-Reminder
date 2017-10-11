package entity;

public class Record {
    private String url;
    private String login;
    private String pass;

    public Record() {
    }

    public Record(String url, String login, String pass) {
        this.url = url;
        this.login = login;
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "url=" + url + ", login=" + login + ", pass=" + pass + ';';
    }
    
}
