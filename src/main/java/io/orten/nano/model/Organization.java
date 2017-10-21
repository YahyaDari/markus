package io.orten.nano.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import javax.persistence.*;
import java.io.Serializable;

/**
* represents an organization raising fund for one or more projects
*/

@Entity
@Table(name="organization")
@SelectBeforeUpdate(value = true)
@DynamicUpdate(value = true)
public class Organization implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name="organizationID")
    public String organizationId;
    @Column(name="name")
    public String name;
    @Column(name="address")
    public String address;
    @Column(name="contactPerson")
    public String contactPersonName;
    @Column(name="contactPersonEmail")
    public String contactPersonEmail;
    @Column(name="password")
    public String password;
    @Column(name="billingInformation")
    public String billingInformation;
    @Column(name="accountNumber")
    public String accountNumber;
    @Column(name="description")
    public String description;

    /*
    * required by hibernate
    */

    public Organization()
    {

    }
    /**
    * Bussiness Constructor
    */
    public Organization(String organizationId, String name, String address, String contactPersonName,
                        String contactPersonTelephone, String contactPersonEmail, String password, String billingInformation,
                        String accountNumber, String description) {
        this.organizationId = organizationId;
        this.name = name;
        this.address = address;
        this.contactPersonName = contactPersonName;
        this.contactPersonEmail = contactPersonEmail;
        this.password = password;
        this.billingInformation = billingInformation;
        this.accountNumber = accountNumber;
        this.description = description;
    }
}