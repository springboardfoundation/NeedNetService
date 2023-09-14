package org.springboardfoundation.fileservice.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetProperties {
    private long ttl;
    private String assetBasePath;
    private String folder;
}