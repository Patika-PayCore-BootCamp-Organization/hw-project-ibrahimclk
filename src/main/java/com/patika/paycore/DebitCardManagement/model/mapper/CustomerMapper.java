package com.patika.paycore.DebitCardManagement.model.mapper;

import com.patika.paycore.DebitCardManagement.model.Customer;
import com.patika.paycore.DebitCardManagement.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDTO toDto(Customer entity);

    Customer toEntity(CustomerDTO dto);

}
