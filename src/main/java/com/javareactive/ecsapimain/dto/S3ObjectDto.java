package com.javareactive.ecsapimain.dto;

import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class S3ObjectDto {
    private String folderName;
    private List<String> objectKeys;
}
