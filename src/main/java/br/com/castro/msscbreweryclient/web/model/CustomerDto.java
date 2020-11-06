package br.com.castro.msscbreweryclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @Author Elias Castro em 27/10/2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    private UUID id;
    private String name;
}
