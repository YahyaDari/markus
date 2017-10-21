package io.orten.nano.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    //TODO: I think we should have long type and auto increment PK.
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectID")
    private String projectID;
    @Column(name = "name")
    private String name;
    @Column(name = "fromDate")
    private Date fromDate;
    @Column(name = "toDate")
    private Date toDate;
    @Column(name = "longitude")
    private float longitude;
    @Column(name = "latitude")
    private float latitude;
    @Column(name = "amountToBeRaised")
    private double amountToBeRaised;
    @Column(name = "description")
    private String description;
    @Column(name = "imageOrvideo")
    private String imageOrvideo;
    @Column(name = "projectManager")
    private String projectManager;
    @Column(name = "nationalProject")
    private boolean nationalProject;
    @Column(name = "recurringProject")
    private boolean recurringProject;
    @Column(name = "recurringProjectPublishingDate")
    private Date recurringProjectPublishingDate;
    @Column(name = "organizationID")
    private String organizationID;

    public Project(){}
    public String getProjectID() {
        return projectID;
    }
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    public Date getToDate() {
        return toDate;
    }
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    public float getLongitude() {
        return longitude;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    public float getLatitude() {
        return latitude;
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public double getAmountToBeRaised() {
        return amountToBeRaised;
    }
    public void setAmountToBeRaised(double amountToBeRaised) {
        this.amountToBeRaised = amountToBeRaised;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImageOrvideo() {
        return imageOrvideo;
    }
    public void setImageOrvideo(String imageOrvideo) {
        this.imageOrvideo = imageOrvideo;
    }
    public String getProjectManager() {
        return projectManager;
    }
    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }
    public boolean isNationalProject() {
        return nationalProject;
    }
    public void setNationalProject(boolean nationalProject) {
        this.nationalProject = nationalProject;
    }
    public boolean isRecurringProject() {
        return recurringProject;
    }
    public void setRecurringProject(boolean recurringProject) {
        this.recurringProject = recurringProject;
    }
    public Date getRecurringProjectPublishingDate() {
        return recurringProjectPublishingDate;
    }
    public void setRecurringProjectPublishingDate(Date recurringProjectPublishingDate) {
        this.recurringProjectPublishingDate = recurringProjectPublishingDate;}
    public String getOrganizationID() {
        return organizationID;
    }
    public void setOrganizationID(String organizationID) {
        this.organizationID = organizationID;
    }
}