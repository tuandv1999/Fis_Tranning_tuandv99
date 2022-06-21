package com.fresher.model;

import com.fresher.core.CaseStatus;
import com.fresher.core.CaseType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="criminalcase")
public class CriminalCase {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="version")
    private int  version;
    @Column(name="number")
    private String number;
    @Column(name="type")
    private CaseType type;
    @Column(name="shortDescription")
    private String shortDescription;
    @Column(name="detailedDescription")
    private String detailedDescription;
    @Column(name="status")
    private CaseStatus status;
    //very big text
    @Column(name="notes")
    private String notes;

    public CriminalCase() {
        super();
        this.status = CaseStatus.SUBMITTED;
        this.type = CaseType.UNCATEGORIZED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CaseType getType() {
        return type;
    }

    public void setType(CaseType type) {
        this.type = type;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public CaseStatus getStatus() {
        return status;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;

    }

    @Override
    public String toString() {
        return "CriminalCase{" +
                "id=" + id +
                ", version=" + version +
                ", number='" + number + '\'' +
                ", type=" + type +
                ", shortDescription='" + shortDescription + '\'' +
                ", detailedDescription='" + detailedDescription + '\'' +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriminalCase that = (CriminalCase) o;
        return version == that.version &&
                id.equals(that.id) &&
                number.equals(that.number) &&
                type == that.type &&
                shortDescription.equals(that.shortDescription) &&
                detailedDescription.equals(that.detailedDescription) &&
                status == that.status &&
                notes.equals(that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, number, type, shortDescription, detailedDescription, status, notes);
    }
}
