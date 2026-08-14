package org.fusadora.springmcpapp.service;

import org.fusadora.springmcpapp.model.DataProduct;

import java.util.List;

public interface DataProductService {

    public void saveDataProduct(DataProduct dataProduct);
    public DataProduct getDataProduct(String dataProductId);
    public void deleteDataProduct(String dataProductId);
    public void updateDataProduct(DataProduct dataProduct);
    public boolean dataProductExists(String dataProductId);
    public void validateDataProduct(DataProduct dataProduct);
    public List<Long> getAllDataProductIds();
    public List<DataProduct> getAllDataProducts();
}
