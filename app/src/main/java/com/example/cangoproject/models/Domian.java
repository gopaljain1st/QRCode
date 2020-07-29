package com.example.cangoproject.models;

public class Domian {

    String domain_name,domain_id,domain_number;

    public Domian(String domain_name, String domain_id, String domain_number) {
        this.domain_name = domain_name;
        this.domain_id = domain_id;
        this.domain_number = domain_number;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    public String getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(String domain_id) {
        this.domain_id = domain_id;
    }

    public String getDomain_number() {
        return domain_number;
    }

    public void setDomain_number(String domain_number) {
        this.domain_number = domain_number;
    }
}
