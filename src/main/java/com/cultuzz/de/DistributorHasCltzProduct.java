package com.cultuzz.de;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * @hibernate.class table="cltzProductDB.distributor_has_cltzProduct"
 * 
 */
public class DistributorHasCltzProduct implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** identifier field */
    private int distributorId;

    /** identifier field */
    private int cltzProductId;
    
    private String status="1";

    /** full constructor */
    public DistributorHasCltzProduct(int distributorId, int cltzProductId,String status) {
        this.distributorId = distributorId;
        this.cltzProductId = cltzProductId;
        this.status = status;
    }

    /** default constructor */
    public DistributorHasCltzProduct() {
    }

    /**
     * @hibernate.property column="distributorId" length="10"
     * 
     */
    public int getDistributorId() {
        return this.distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }
    
    
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
     * @hibernate.property column="cltzProductId" length="10"
     * 
     */
    public int getCltzProductId() {
        return this.cltzProductId;
    }

    public void setCltzProductId(int cltzProductId) {
        this.cltzProductId = cltzProductId;
    }

    public String toString() {
        return new ToStringBuilder(this).append("distributorId", getDistributorId()).append("cltzProductId", getCltzProductId()).toString();
    }

    public boolean equals(Object other) {
        if((this == other)) return true;
        if(!(other instanceof DistributorHasCltzProduct)) return false;
        DistributorHasCltzProduct castOther = (DistributorHasCltzProduct) other;
        return new EqualsBuilder().append(this.getDistributorId(), castOther.getDistributorId()).append(this.getCltzProductId(), castOther.getCltzProductId()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getDistributorId()).append(getCltzProductId()).toHashCode();
    }

}
