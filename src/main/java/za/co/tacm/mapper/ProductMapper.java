package za.co.tacm.mapper;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import za.co.tacm.entity.ProductEntity;
import za.co.tacm.model.Product;

@Mapper(componentModel = "cdi")
public interface ProductMapper {
    

    @Mappings({
        @Mapping(target = "farmer_id", source = "productEntity.farmer.id" )
    })
    Product mapToProduct(ProductEntity productEntity );
    ProductEntity mapToProductEntity(Product product);
    List<Product> mapToProduct(final List<ProductEntity> products);

}
