package com.nray.tenpo.service.mapper;

import com.nray.tenpo.dto.CallHistoryDto;
import com.nray.tenpo.entity.CallHistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CallHistoryMapper {

    CallHistoryMapper INSTANCE = Mappers.getMapper(CallHistoryMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "timestamp", target = "timestamp")
    @Mapping(source = "endpoint", target = "endpoint")
    @Mapping(source = "parameters", target = "parameters")
    @Mapping(source = "response", target = "response")
    @Mapping(source = "error", target = "error")
    CallHistoryDto entityToDto(CallHistoryEntity entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "timestamp", target = "timestamp")
    @Mapping(source = "endpoint", target = "endpoint")
    @Mapping(source = "parameters", target = "parameters")
    @Mapping(source = "response", target = "response")
    @Mapping(source = "error", target = "error")
    CallHistoryEntity dtoToentity(CallHistoryDto dto);
}
