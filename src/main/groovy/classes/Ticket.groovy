package classes

import groovy.transform.Immutable

@Immutable
class Ticket {
    String client
    Integer number

    // Em Java
    /**
    private Ticket() {
    }

    Ticket(String client, Integer number) {
        this.client = client
        this.number = number
    }

    String getClient() {
        return client
    }

    Integer getNumber() {
        return number
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (o == null || getClass() != o.class) return false

        Ticket ticket = (Ticket) o

        if (client != ticket.client) return false
        if (number != ticket.number) return false

        return true
    }

    int hashCode() {
        int result
        result = (client != null ? client.hashCode() : 0)
        result = 31 * result + (number != null ? number.hashCode() : 0)
        return result
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "client='" + client + '\'' +
                ", number=" + number +
                '}';
    }
    **/
}
