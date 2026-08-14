package org.fusadora.springmcpapp.service;

import org.fusadora.springmcpapp.model.DataProduct;
import org.fusadora.springmcpapp.repository.DataProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

/**
 * org.fusadora.springmcpapp.service.DataProductServiceImpl
 * Implementation of the DataProductService interface for managing DataProduct entities.
 *
 * @author Parag Ghosh
 * @since 14/08/2026
 */
@Service
public class DataProductServiceImpl implements DataProductService {

    @Autowired
    private DataProductRepository dataProductRepository;

    /**
     * Saves a new DataProduct.
     *
     * @param dataProduct the DataProduct to be saved
     * @throws IllegalArgumentException if the dataProduct is null
     */
    @Override
    public void saveDataProduct(DataProduct dataProduct) {
        if (dataProduct == null) {
            throw new IllegalArgumentException("DataProduct cannot be null");
        }
        dataProductRepository.save(dataProduct);
    }

    /**
     * Retrieves a DataProduct by its ID.
     *
     * @param dataProductId the ID of the dataProduct to retrieve
     * @return the DataProduct with the specified ID
     * @throws IllegalArgumentException if the dataProduct ID format is invalid or the dataProduct is not found
     */
    @Override
    public DataProduct getDataProduct(String dataProductId) {
        try {
            Long id = Long.parseLong(dataProductId);
            return dataProductRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("DataProduct not found with id: " + dataProductId));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid dataProduct ID format: " + dataProductId, e);
        }
    }

    /**
     * Deletes a DataProduct by its ID.
     *
     * @param dataProductId the ID of the dataProduct to delete
     * @throws IllegalArgumentException if the dataProduct ID format is invalid or the dataProduct is not found
     */
    @Override
    public void deleteDataProduct(String dataProductId) {
        try {
            Long id = Long.parseLong(dataProductId);
            if (!dataProductRepository.existsById(id)) {
                throw new IllegalArgumentException("DataProduct not found with id: " + dataProductId);
            }
            dataProductRepository.deleteById(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid dataProduct ID format: " + dataProductId, e);
        }
    }

    /**
     * Updates an existing DataProduct.
     *
     * @param dataProduct the DataProduct to be updated
     * @throws IllegalArgumentException if the dataProduct is null or not found
     */
    @Override
    public void updateDataProduct(DataProduct dataProduct) {
        if (!dataProductRepository.existsById(dataProduct.getDataProductId())) {
            throw new IllegalArgumentException("DataProduct not found with id: " + dataProduct.getDataProductId());
        }
        dataProductRepository.save(dataProduct);
    }

    /**
     * Checks if a DataProduct exists by its ID.
     *
     * @param dataProductId the ID of the dataProduct to check
     * @return true if the dataProduct exists, false otherwise
     * @throws IllegalArgumentException if the dataProduct ID format is invalid
     */
    @Override
    public boolean dataProductExists(String dataProductId) {
        try {
            Long id = Long.parseLong(dataProductId);
            return dataProductRepository.existsById(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid dataProduct ID format: " + dataProductId, e);
        }
    }

    /**
     * Validates a DataProduct.
     *
     * @param dataProduct the DataProduct to be validated
     * @throws IllegalArgumentException if the dataProduct is null or has invalid fields
     */
    @Override
    public void validateDataProduct(DataProduct dataProduct) {
        if (dataProduct == null) {
            throw new IllegalArgumentException("DataProduct cannot be null");
        }
        if (dataProduct.getDataProductName() == null || dataProduct.getDataProductName().isEmpty()) {
            throw new IllegalArgumentException("DataProduct name cannot be null or empty");
        }
    }

    /**
     * Retrieves all dataProduct IDs.
     *
     * @return a list of all dataProduct IDs
     */
    @Override
    public List<Long> getAllDataProductIds() {
        return StreamSupport.stream(dataProductRepository.findAll().spliterator(), false).map(DataProduct::getDataProductId).toList();
    }

    /**
     * Retrieves all DataProducts.
     *
     * @return a list of all DataProducts
     */
    @Override
    public List<DataProduct> getAllDataProducts() {
        return StreamSupport.stream(dataProductRepository.findAll().spliterator(), false).toList();
    }
}
