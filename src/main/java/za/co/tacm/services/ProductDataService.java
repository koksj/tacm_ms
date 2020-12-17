package za.co.tacm.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.tacm.entity.FarmerEntity;
import za.co.tacm.entity.ProductEntity;
import za.co.tacm.mapper.ProductMapper;
import za.co.tacm.model.Product;

@ApplicationScoped
public class ProductDataService {

    private static final Logger log = LoggerFactory.getLogger(ProductDataService.class);
    
    @Inject
    EntityManager em;

    @Inject
    ProductMapper productMapper;

    public ProductDataService() {
    }

     /**
     * Creates a Product if it does not exist. If he exists upadte the farmer.
     * 
     * @param product
     */
    public Product getProduct(String productCode) {

        ProductEntity productEntity = em.createNamedQuery("Product.findProductByProductCode", ProductEntity.class)
                .setParameter("productCode", productCode).getSingleResult();

        if (productEntity == null) {
            log.info("No data for product code: " + productCode);
            productEntity = new ProductEntity();
            productEntity.setProductCode(productCode);
        } else {
            log.info("Product code fetched: " + productEntity.getProductCode());
        }
        Product product = productMapper.mapToProduct(productEntity);

        return product;
    }

    @Transactional
    public void persistProduct(String farmer_id, ProductEntity productEntity) {

        FarmerEntity farmerEntity = new FarmerEntity();      

        try {
            // Get the famer details
            farmerEntity = em.createNamedQuery("Farmer.findFarmerById", FarmerEntity.class)
                    .setParameter("id", farmer_id).getSingleResult();

        } catch (Exception e) {
            log.error("Famer :" + farmer_id + " not found.");
        }

        ProductEntity product = new ProductEntity();
        try {
            // Get the product details
            product = em.createNamedQuery("Product.findProductByProductCode", ProductEntity.class)
                    .setParameter("productCode", productEntity.getProductCode()).getSingleResult();

        } catch (Exception e) {
            log.error("Product: " + productEntity.getProductCode() + " not found.");
        }

        if (farmerEntity != null && product != null) {
            log.info("Product exists: " + productEntity.getProductCode());
            productEntity.setPoduct_pk(product.getPoduct_pk());
            productEntity.setFarmer(farmerEntity);
            em.merge(productEntity);
            return;
        }

        if (farmerEntity == null) {
            log.error(
                    "Product code: " + productEntity.getProductCode() + " for farmer: " + farmer_id + "not persited.");
        } else {
            farmerEntity.addProduct(productEntity);
            em.merge(farmerEntity);
            log.info("Product code: " + productEntity.getProductCode() + " for farmer: " + farmer_id + " persited.");
        }
    }

    @Transactional
    public void deleteProduct(String productCode) {

        ProductEntity productEntity = new ProductEntity();

        // ProductEntity productEntity = em.find(ProductEntity.class, id);
        productEntity = em.createNamedQuery("Product.findProductByProductCode", ProductEntity.class)
                .setParameter("productCode", productCode).getSingleResult();

        if (productEntity == null) {
            log.error("Failed to remove product code: " + productCode);
        } else {
            em.remove(productEntity);
            log.info("Product code " + productCode + " deleted");
        }

    }

    public List<ProductEntity> getProducts(String farmerID) {

        FarmerEntity farmerEntity = new FarmerEntity();
        List<ProductEntity> products = new ArrayList<>();

        try {
            farmerEntity = em.createNamedQuery("Farmer.findFarmerById", FarmerEntity.class).setParameter("id", farmerID)
                    .getSingleResult();

            products.addAll(farmerEntity.getProducts());

        } catch (Exception e) {
            log.error("An error occured no products found for famer id: " + farmerID, e);
        }

        return products;
    }
    
}
