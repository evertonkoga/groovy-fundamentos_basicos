package classes

class ClientInJava {
    private String name;
    private Date createAt;

    ClientInJava(String name) {
        this.name = name
    }

    ClientInJava(Date createAt) {
        this.createAt = createAt
    }

    ClientInJava(String name, Date createAt) {
        this.name = name
        this.createAt = createAt
    }

    public Integer sum(Integer number1, Integer number2) {
        return number1 + number2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
