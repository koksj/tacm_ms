package za.co.tacm.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.tacm.entity.ProductEntity;
import za.co.tacm.mapper.ProductMapper;
import za.co.tacm.model.Product;
import za.co.tacm.services.ProductDataService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/tacm")
public class ProductResource {

    private static final Logger log = LoggerFactory.getLogger(ProductResource.class);

    @Inject
    ProductMapper productMapper;

    @Inject
    ProductDataService dataService;
 

    public ProductResource() {
    }

    @POST
    @Path("/v1/product")
    public Response product(Product product) {

        ProductEntity productEntity = productMapper.mapToProductEntity(product);
        dataService.persistProduct(product.getFarmer_id(),productEntity);

        return Response.ok().build();
    }

    @GET
    @Path("/v1/product/{productCode}") 
    public Response getProduct(@PathParam("productCode") String productCode) {

        Product product = dataService.getProduct(productCode);
        return Response.ok(product).build();
    }


    @GET
    @Path("/v1/products/{farmer_id}")
    public Response product(@PathParam("farmer_id") String farmer_id) {

        List<ProductEntity> products = dataService.getProducts(farmer_id);
        log.info("Products size: "  + products.size());
        
        return Response.ok(productMapper.mapToProduct(products)).build();
    }

    @DELETE
    @Path("/v1/product/{productCode}")
    public Response deleteAgent(@PathParam("productCode") String productCode) {

        dataService.deleteProduct(productCode);

        return Response.ok().build();
    }

}
