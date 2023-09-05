package com.bloodMatch.business.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@ApiModel(description = "Model of Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BloodStorageOrder {
    @ApiModelProperty(notes = "The unique ID of the order")
    private Long id;

    @NotNull(message = "Blood info ID cannot be null")
    @ApiModelProperty(notes = "The blood info ID", example = "1")
    private Long bloodInfoId;

    @NotNull(message = "Patient unique number cannot be null")
    @ApiModelProperty(notes = "The patient unique number", example = "30175d49")
    String uniqueNumber;

    @ApiModelProperty(notes = "The order time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime;
}
