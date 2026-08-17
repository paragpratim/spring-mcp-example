package org.fusadora.springmcpapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import com.google.cloud.spring.data.datastore.core.mapping.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(DataProduct.class);

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @JsonProperty("data_product_id")
    @Field(name = "data_product_id")
    private Long dataProductId;

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

    public Long getDataProductId() {
        return dataProductId;
    }

    public void setDataProductId(Long dataProductId) {
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

    @Override
    public String toString() {
        try {
            return MAPPER.writeValueAsString(this);
        } catch (Exception e) {
            LOGGER.warn("Error converting DataProduct to JSON: {}", e.getMessage(), e);
            return String.format("Error converting DataProduct to JSON: %s", e.getMessage());
        }
    }
}
