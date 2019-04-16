package model;

public class Account {
    private String id;
    private String password;

    public Account(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(Account account) {
        return this.id.equals(account.getId()) && this.password.equals(account.password);
    }
}
