package org.fusadora.springmcpapp.mcp.tool;

import org.fusadora.springmcpapp.service.DataProductService;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * org.fusadora.springmcpapp.mcp.tool.DataProductTool
 * MCP tool for interacting with data products in the SpringMCPApp.
 *
 * @author Parag Ghosh
 * @since 15/08/2026
 */
@Service
public class DataProductTool {
    @Autowired
    private DataProductService dataProductService;

    @McpTool(description = "Get information about a data product by its ID")
    public String getDataProductInfo(
            @McpToolParam(description = "The ID of the data product") String dataProductId
    ) {
        return String.format("Data Product Info: %s", dataProductService.getDataProduct(dataProductId));
    }
}
