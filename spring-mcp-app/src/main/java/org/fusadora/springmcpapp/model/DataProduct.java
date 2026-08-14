package org.fusadora.springmcpapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import com.google.cloud.spring.data.datastore.core.mapping.Field;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;

/**
 * org.fusadora.springmcpapp.model.DataProduct
 * This class represents a data product entity for managing data products.
 *
 * @author Parag Ghosh
 * @since 14/08/2026
 */
@Entity(name = "data_product")
public class DataProduct implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @JsonProperty("data_product_id")
    @Field(name = "data_product_id")
    private long dataProductId;

    @JsonProperty("data_product_name")
    @Field(name = "data_product_name")
    private String dataProductName;

    @JsonProperty("data_product_description")
    @Field(name = "data_product_description")
    private String dataProductDescription;

    @JsonProperty("data_product_category")
    @Field(name = "data_product_category")
    private String dataProductCategory;

    @JsonProperty("data_product_owner")
    @Field(name = "data_product_owner")
    private String dataProductOwner;

    @JsonProperty("data_product_version")
    @Field(name = "data_product_version")
    private double dataProductVersion;

    public long getDataProductId() {
        return dataProductId;
    }

    public void setDataProductId(long dataProductId) {
        this.dataProductId = dataProductId;
    }

    public String getDataProductName() {
        return dataProductName;
    }

    public void setDataProductName(String dataProductName) {
        this.dataProductName = dataProductName;
    }

    public String getDataProductDescription() {
        return dataProductDescription;
    }

    public void setDataProductDescription(String dataProductDescription) {
        this.dataProductDescription = dataProductDescription;
    }

    public String getDataProductCategory() {
        return dataProductCategory;
    }

    public void setDataProductCategory(String dataProductCategory) {
        this.dataProductCategory = dataProductCategory;
    }

    public String getDataProductOwner() {
        return dataProductOwner;
    }

    public void setDataProductOwner(String dataProductOwner) {
        this.dataProductOwner = dataProductOwner;
    }

    public double getDataProductVersion() {
        return dataProductVersion;
    }

    public void setDataProductVersion(double dataProductVersion) {
        this.dataProductVersion = dataProductVersion;
    }
}
