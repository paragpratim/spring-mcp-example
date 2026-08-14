package org.fusadora.springmcpapp.repository;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import org.fusadora.springmcpapp.model.DataProduct;
import org.springframework.stereotype.Repository;

@Repository
public interface DataProductRepository extends DatastoreRepository<DataProduct, Long> {
}
