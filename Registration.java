package main;

public class Registration {
    private String firstName;
    private String lastName;
    private String fatherName;
    private String  phoneNumber;
    private String cnicNumber;
    private String email;
    private String password;
    private String cPassword;

    private static Registration instance;
    private Registration(){}
    public static Registration getInstance(){
        if(instance==null){
            instance=new Registration();
        }
      return instance;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCnicNumber(String cnicNumber) {
        this.cnicNumber = cnicNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}