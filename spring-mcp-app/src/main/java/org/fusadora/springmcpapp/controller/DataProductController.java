package org.fusadora.springmcpapp.controller;

import org.fusadora.springmcpapp.model.DataProduct;
import org.fusadora.springmcpapp.service.DataProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * org.fusadora.springmcpapp.controller.DataProductController
 * <p>Description: Controller for managing DataProduct entities.</p>
 *
 * @author Parag Ghosh
 * @since 14/08/2026
 */
@RestController
@RequestMapping("/api/dataproducts")
public class DataProductController {

    private final Logger logger = LoggerFactory.getLogger(DataProductController.class);

    @Autowired
    private DataProductService dataProductService;

    /**
     * Save a new DataProduct.
     *
     * @param dataProduct The DataProduct object to be saved.
     * @return A success message or error message.
     */
    @PostMapping("/save")
    public String saveDataProduct(@RequestBody DataProduct dataProduct) {
        try {
            dataProductService.saveDataProduct(dataProduct);
            return String.format("DataProduct [%d] saved successfully", dataProduct.getDataProductId());
        } catch (Exception e) {
            logger.error("Error saving DataProduct: ", e);
            return "Error saving product: " + e.getMessage();
        }
    }

    /**
     * Retrieve a DataProduct by its ID.
     *
     * @param dataProductId The ID of the DataProduct to retrieve.
     * @return The DataProduct object.
     */
    @GetMapping("/get/{dataProductId}")
    public DataProduct getDataProduct(@PathVariable String dataProductId) {
        return dataProductService.getDataProduct(dataProductId);
    }

    /**
     * Delete a DataProduct by its ID.
     *
     * @param dataProductId The ID of the DataProduct to delete.
     * @return A success message or error message.
     */
    @DeleteMapping("/delete/{dataProductId}")
    public String deleteDataProduct(@PathVariable String dataProductId) {
        try {
            dataProductService.deleteDataProduct(dataProductId);
            return "DataProduct deleted successfully";
        } catch (Exception e) {
            logger.error("Error deleting DataProduct: ", e);
            return "Error deleting DataProduct: " + e.getMessage();
        }
    }

    /**
     * Update an existing DataProduct.
     *
     * @param dataProduct The DataProduct object with updated information.
     * @return A success message or error message.
     */
    @PutMapping("/update")
    public String updateDataProduct(@RequestBody DataProduct dataProduct) {
        try {
            dataProductService.updateDataProduct(dataProduct);
            return String.format("DataProduct [%d] updated successfully", dataProduct.getDataProductId());
        } catch (Exception e) {
            logger.error("Error updating DataProduct: ", e);
            return "Error updating DataProduct: " + e.getMessage();
        }
    }

    /**
     * Check if a DataProduct exists by its ID.
     *
     * @param dataProductId The ID of the DataProduct to check.
     * @return True if the DataProduct exists, false otherwise.
     */
    @GetMapping("/exists/{dataProductId}")
    public boolean dataProductExists(@PathVariable String dataProductId) {
        return dataProductService.dataProductExists(dataProductId);
    }

    /**
     * Retrieve all DataProduct IDs.
     *
     * @return A list of all DataProduct IDs.
     */
    @GetMapping("/all-ids")
    public List<Long> getAllDataProductIds() {
        return dataProductService.getAllDataProductIds();
    }

    /**
     * Retrieve all data products.
     *
     * @return A list of all DataProduct objects.
     */
    @GetMapping("/all")
    public List<DataProduct> getAllDataProducts() {
        return dataProductService.getAllDataProducts();
    }

    /**
     * Validate a data product.
     *
     * @param dataProduct The DataProduct object to validate.
     * @return A success message or error message.
     */
    @PostMapping("/validate")
    public String validateDataProduct(@RequestBody DataProduct dataProduct) {
        try {
            dataProductService.validateDataProduct(dataProduct);
            return "DataProduct is valid";
        } catch (Exception e) {
            return "DataProduct validation failed: " + e.getMessage();
        }
    }
}
