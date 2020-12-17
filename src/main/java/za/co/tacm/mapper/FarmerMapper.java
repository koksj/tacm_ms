package za.co.tacm.mapper;

import org.mapstruct.Mapper;
import za.co.tacm.entity.FarmerEntity;
import za.co.tacm.model.Farmer;

@Mapper(componentModel = "cdi")
public interface FarmerMapper {
  
  public Farmer mapToFarmer(FarmerEntity farmerEntity);
  public FarmerEntity mapToFarmerEntity(Farmer farmer);
            
}
