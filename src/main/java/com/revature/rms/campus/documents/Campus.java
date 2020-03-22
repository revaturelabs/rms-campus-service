package com.revature.rms.campus.documents;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.revature.rms.core.models.Resource;
import com.revature.rms.core.models.ResourceMetadata;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Document
@JsonPropertyOrder({
        "id",
        "name",
        "abbr",
        "shippingAddress",
        "trainingManager",
        "stagingManager",
        "hrLead",
        "buildings",
        "corporateEmployees",
        "metadata"
})
public class Campus extends Resource {

    @NotNull @NotEmpty
    private String name;

    @NotNull @NotEmpty
    private String abbr;

    @NotNull
    private Address shippingAddress;

    @NotNull @NotEmpty
    private String trainingManager;

    @NotNull @NotEmpty
    private String stagingManager;

    @NotNull @NotEmpty
    private String hrLead;

    @NotNull @NotEmpty
    private List<Building> buildings;

    @NotNull @NotEmpty
    private List<String> corporateEmployees;

    public Campus() {
        super();
        buildings = new ArrayList<>();
        corporateEmployees = new ArrayList<>();
    }

    public Campus(@NotNull @NotEmpty String name, @NotNull @NotEmpty String abbr, @NotNull Address shippingAddress,
                  @NotNull @NotEmpty String trainingManager, @NotNull @NotEmpty String stagingManager,
                  @NotNull @NotEmpty String hrLead) {
        this();
        this.name = name;
        this.abbr = abbr;
        this.shippingAddress = shippingAddress;
        this.trainingManager = trainingManager;
        this.stagingManager = stagingManager;
        this.hrLead = hrLead;
    }

    public Campus(@NotNull @NotEmpty String name, @NotNull @NotEmpty String abbr, @NotNull Address shippingAddress,
                  @NotNull @NotEmpty String trainingManager, @NotNull @NotEmpty String stagingManager,
                  @NotNull @NotEmpty String hrLead, @NotNull @NotEmpty List<Building> buildings,
                  @NotNull @NotEmpty List<String> corporateEmployees) {
        this(name, abbr, shippingAddress, trainingManager, stagingManager, hrLead);
        this.buildings = buildings;
        this.corporateEmployees = corporateEmployees;
    }

    public Campus(@NotNull @NotEmpty String name, @NotNull @NotEmpty String abbr, @NotNull Address shippingAddress,
                  @NotNull @NotEmpty String trainingManager, @NotNull @NotEmpty String stagingManager,
                  @NotNull @NotEmpty String hrLead, @NotNull @NotEmpty List<Building> buildings,
                  @NotNull @NotEmpty List<String> corporateEmployees, ResourceMetadata metadata) {
        this(name, abbr, shippingAddress, trainingManager, stagingManager, hrLead, buildings, corporateEmployees);
        this.metadata = metadata;
    }

    public Campus(String id, ResourceMetadata metadata, @NotNull @NotEmpty String name, @NotNull @NotEmpty String abbr,
                  @NotNull Address shippingAddress, @NotNull @NotEmpty String trainingManager,
                  @NotNull @NotEmpty String stagingManager, @NotNull @NotEmpty String hrLead,
                  @NotNull @NotEmpty List<Building> buildings, @NotNull @NotEmpty List<String> corporateEmployees) {
        this(name, abbr, shippingAddress, trainingManager, stagingManager, hrLead, buildings, corporateEmployees, metadata);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Campus setName(String name) {
        this.name = name;
        return this;
    }

    public String getAbbr() {
        return abbr;
    }

    public Campus setAbbr(String abbr) {
        this.abbr = abbr;
        return this;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public Campus setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public String getTrainingManager() {
        return trainingManager;
    }

    public Campus setTrainingManager(String trainingManager) {
        this.trainingManager = trainingManager;
        return this;
    }

    public String getStagingManager() {
        return stagingManager;
    }

    public Campus setStagingManager(String stagingManager) {
        this.stagingManager = stagingManager;
        return this;
    }

    public String getHrLead() {
        return hrLead;
    }

    public Campus setHrLead(String hrLead) {
        this.hrLead = hrLead;
        return this;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public Campus setBuildings(List<Building> buildings) {
        this.buildings = buildings;
        return this;
    }

    public Campus addBuildings(Building... buildings) {
        this.buildings.addAll(Arrays.asList(buildings));
        return this;
    }

    public List<String> getCorporateEmployees() {
        return corporateEmployees;
    }

    public Campus setCorporateEmployees(List<String> corporateEmployees) {
        this.corporateEmployees = corporateEmployees;
        return this;
    }

    public Campus addCorporateEmployees(String... corporateEmpIds) {
        this.corporateEmployees.addAll(Arrays.asList(corporateEmpIds));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campus campus = (Campus) o;
        return name.equals(campus.name) &&
                abbr.equals(campus.abbr) &&
                shippingAddress.equals(campus.shippingAddress) &&
                trainingManager.equals(campus.trainingManager) &&
                stagingManager.equals(campus.stagingManager) &&
                hrLead.equals(campus.hrLead) &&
                buildings.equals(campus.buildings) &&
                corporateEmployees.equals(campus.corporateEmployees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, abbr, shippingAddress, trainingManager, stagingManager, hrLead, buildings, corporateEmployees);
    }

    @Override
    public String toString() {
        return "Campus{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", abbr='" + abbr + '\'' +
                ", shippingAddress=" + shippingAddress +
                ", trainingManager='" + trainingManager + '\'' +
                ", stagingManager='" + stagingManager + '\'' +
                ", hrLead='" + hrLead + '\'' +
                ", buildings=" + buildings +
                ", corporateEmployees=" + corporateEmployees +
                ", metadata=" + metadata +
                '}';
    }
}
