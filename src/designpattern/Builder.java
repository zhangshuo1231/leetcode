package designpattern;

class Developer {
    private String name;
    private int age;
    private String codingLanguage;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCodingLanguage() {
        return codingLanguage;
    }

    private Developer(DeveloperBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.codingLanguage = builder.codingLanguage != null ? builder.codingLanguage : "Java";
    }

    public static class DeveloperBuilder {
        private String name;
        private int age;
        private String codingLanguage;

        public DeveloperBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public void setCodingLanguage(String codingLanguage) {
            this.codingLanguage = codingLanguage;
        }
        public Developer build() {
            return new Developer(this);
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        Developer me = new Developer.DeveloperBuilder("Shawn", 40).build();
        System.out.println(me.getName() + ": " + me.getAge() + ", " + me.getCodingLanguage());
    }
}
