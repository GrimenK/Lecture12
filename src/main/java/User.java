public class User {

    public String name;

    @CustomFieldAnnotation(description = "This is field that contains persons id information")
    private String documentID;

    public int age;

    @CustomFieldAnnotation(description = "This is field that contains persons income per year")
    public int income;

    public String lastName;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", documentID='" + documentID + '\'' +
                ", age=" + age +
                ", income=" + income +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int methodForInvoke(int age){
        return this.age + age;
    }

    public void myMethod(String a, int ... args){
        System.out.println("This is method with int ... args");
    }

    public void myMethod(String ... args){
        System.out.println("This is method with String ... args");
    }
}
