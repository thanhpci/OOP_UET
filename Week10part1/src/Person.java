public class Person implements Comparable {
    String name;
    String address;
    int age;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        if (name != person.name) {
            return name.compareTo(person.name);
        }
        if (age > person.age) {
            return 1;
        }
        if (age < person.age) {
            return -1;
        }
        return 0;

    }
}
