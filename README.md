# spring-mcp-example

This project demonstrates a Spring Boot + Spring AI MCP server that exposes a tool over the Model Context Protocol (MCP). It includes a Docker Compose setup for running the app and the MCP Inspector together.

## Prerequisites

- Docker Desktop or Docker Engine
- Optional: Java 17 and Maven if you want to run the app outside Docker

## Run the stack

Start the backend and inspector together:

```bash
task all
```

## Key project files

### Maven dependencies for the Spring MCP app

The required Spring AI and MCP dependencies are declared in:

- [spring-mcp-app/pom.xml](spring-mcp-app/pom.xml)

Relevant section:

```xml
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-mcp-server-webmvc</artifactId>
</dependency>
```

This is the dependency that enables the Spring MCP server support used by the application.

### Example MCP tool implementation

The sample tool is defined here:

- [spring-mcp-app/src/main/java/org/fusadora/springmcpapp/mcp/tool/DataProductTool.java](spring-mcp-app/src/main/java/org/fusadora/springmcpapp/mcp/tool/DataProductTool.java)

Example implementation:

```java
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
```

This is the core of the MCP server: the method is exposed as an MCP tool and can be discovered and invoked by an MCP client such as the inspector.

## Local access

Open the Swagger UI here to explore the REST API:

```text
http://localhost:8080/swagger-ui/index.html#
```

Open the MCP Inspector UI here:

```text
http://localhost:6274
```

## MCP server URL

The Spring MCP server is exposed at:

```text
http://localhost:8080/mcp
```

When you open the inspector, connect to that URL.

On macOS with Docker Desktop, the Compose default is set to use `host.docker.internal`, which resolves correctly from the container to the host machine.

If you are running Docker on Linux, use the internal Compose service name instead:

```text
http://backend:8080/mcp
```

## Run the inspector locally

If you prefer to start the inspector outside Docker:

```bash
npx @modelcontextprotocol/inspector@latest
```

Then point it to:

```text
http://localhost:8080/mcp
```